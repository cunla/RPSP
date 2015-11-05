package com.emc.rpsp.protect.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emc.rpsp.protect.service.GroupsProtectionService;

@Controller
public class GroupsProtectionController {

	@Autowired
	private GroupsProtectionService groupsProtectionService;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/groups", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<HttpStatus> createConsistencyGroup(
								@RequestBody Map<String, Object> params) {		
		String groupName = params.get("groupName").toString();
		List<Object> vmIdsObj = (List<Object>) params.get("vms");
		List<String> vmIds = new LinkedList<String>();
		vmIdsObj.forEach((obj) -> vmIds.add(String.valueOf(obj)));
		groupsProtectionService.createConsistencyGroup(groupName, vmIds);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/groups/{groupId}/vms", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<HttpStatus> addVmToCG(
			@PathVariable("groupId") Long groupId,
			@RequestBody Map<String, Object> params) {
		boolean isCritical = true;
		int sequenceNumber = 3;
		if (params.get("isCritical") != null) {
			isCritical = Boolean.parseBoolean(params.get("isCritical")
					.toString());
		}
		if (params.get("sequenceNumber") != null) {
			sequenceNumber = Integer.parseInt(params.get("sequenceNumber")
					.toString());
		}
		groupsProtectionService.addVmToCG(params.get("id").toString(), groupId,
				isCritical, sequenceNumber);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/groups/{groupId}/vms/{vmId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<HttpStatus> removeVmsFromCG(
			@PathVariable("vmId") String vmId,
			@PathVariable("groupId") Long groupId) {
		groupsProtectionService.removeVmsFromCG(vmId, groupId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
