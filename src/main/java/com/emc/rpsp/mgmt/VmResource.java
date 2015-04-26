package com.emc.rpsp.mgmt;

import com.emc.rpsp.fal.Client;
import com.emc.rpsp.repository.SystemConnectionInfoRepository;
import com.emc.rpsp.rpsystems.SystemSettings;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by morand3 on 4/26/2015.
 */
@RestController
@RequestMapping("/app")
public class VmResource {
	@Inject
	private SystemConnectionInfoRepository systemConnectionInfoRepository;

	@Inject
	private VmOwnershipRepo vmOwnershipRepo;

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/rest/listVms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VmOwnership>> findCurrentUser() {
		List<SystemSettings> rpSystems = systemConnectionInfoRepository.findAll();
		List<String> vmIdList = new LinkedList<>();
		for(SystemSettings rpSystem:rpSystems){
			Client client = new Client(rpSystem);
			Map<Long, Map<String, String>> vms = client.getVmNamesAllClusters();
			vmIdList.addAll(extractVmIds(vms));
		}
		List<VmOwnership> res = new LinkedList<>();
		for(String vmId:vmIdList){
			VmOwnership vmOwnership = vmOwnershipRepo.findVmOwner(vmId);
			if(null==vmOwnership){
				vmOwnership = new VmOwnership(null,vmId);
				vmOwnershipRepo.save(vmOwnership);
			}
			res.add(vmOwnership);
		}
		vmOwnershipRepo.flush();
		return ResponseEntity.ok(res);
	}

	private List<String> extractVmIds(Map<Long, Map<String, String>> vms) {
		List<String> res = new LinkedList<>();
		for(Long clusterId:vms.keySet()){
			Map<String,String> vmsInCluster = vms.get(clusterId);
			for(String vmId:vmsInCluster.keySet()){
				res.add(vmId);
			}
		}
		return res;
	}
}
