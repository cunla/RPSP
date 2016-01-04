package com.emc.rpsp.protect.controller;

import com.emc.rpsp.backupsystems.BackupApi;
import com.emc.rpsp.config.auditing.AuditConsts;
import com.emc.rpsp.config.auditing.annotations.RpspAuditObject;
import com.emc.rpsp.config.auditing.annotations.RpspAuditResult;
import com.emc.rpsp.config.auditing.annotations.RpspAuditSubject;
import com.emc.rpsp.config.auditing.annotations.RpspAudited;
import com.emc.rpsp.protect.service.GroupsProtectionService;
import com.emc.rpsp.vmstructure.domain.VmDefinition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class GroupsProtectionController {

	@Autowired
	private GroupsProtectionService groupsProtectionService;

	@Autowired
	private BackupApi backupApi;

	@SuppressWarnings("unchecked")
    @RequestMapping(value = "/groups", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @RpspAudited(action = AuditConsts.CREATE_CG)
    @ResponseBody
    public
    @RpspAuditResult(AuditConsts.CREATE_CG_RESULT)
    ResponseEntity<HttpStatus> createConsistencyGroup(
        @RpspAuditSubject(AuditConsts.CREATE_CG_SUBJ_PARAMS) @RpspAuditObject(AuditConsts.CREATE_CG_OBJ_PARAMS) @RequestBody Map<String, Object> params) {
		
        String groupName = params.get("groupName").toString();
        boolean startReplication = Boolean.parseBoolean(params.get("enableReplication").toString());
        long packageId = Long.parseLong(params.get("packageId").toString());
        List<Object> vms = (List<Object>) params.get("vms");
        List<VmDefinition> vmDefs = getVmDefinitions(vms);
        List<String> vmIds = getVmIds(vms);
        
        groupsProtectionService.createConsistencyGroup(groupName, vmIds, startReplication, packageId);
        Boolean backup = (params.get("backup") != null && Boolean.valueOf(params.get("backup").toString()));
        if (backup) {
            String schedule = params.get("schedule").toString();
            backupApi.addVmsToBackupSchedule(vmDefs, schedule);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

	@RequestMapping(value = "/groups/{groupId}/vms", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@RpspAudited(action = AuditConsts.ADD_VM_TO_CG)
	@ResponseBody
	public @RpspAuditResult(AuditConsts.ADD_VM_TO_CG_RESULT) ResponseEntity<HttpStatus> addVmToCG(
			@RpspAuditSubject(AuditConsts.CG) @PathVariable("groupId") Long groupId,
			@RpspAuditObject(AuditConsts.ADD_VM_TO_CG_PARAMS) @RequestBody Map<String, Object> params) {
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
		String vmId = params.get("id").toString();
		
		groupsProtectionService.addVmToCG(vmId, groupId, isCritical,
				sequenceNumber);
		
		
		
		Boolean backup = (params.get("backup") != null && Boolean.valueOf(params.get("backup").toString()));
		if (backup) {
			String schedule = params.get("schedule").toString();
			String vmName = params.get("name").toString();
			VmDefinition vmDefinition = new VmDefinition(vmId, vmName);
			ArrayList<VmDefinition> vmDefs = new ArrayList<VmDefinition>(Arrays.asList(vmDefinition));
			backupApi.addVmsToBackupSchedule(vmDefs, schedule);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/groups/{groupId}/vms/{vmId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@RpspAudited(action = AuditConsts.REMOVE_VM_FROM_CG)
	@ResponseBody
	public @RpspAuditResult(AuditConsts.REMOVE_VM_FROM_CG_RESULT) ResponseEntity<HttpStatus> removeVmsFromCG(
			@RpspAuditObject(AuditConsts.VM) @PathVariable("vmId") String vmId,
			@RpspAuditSubject(AuditConsts.CG) @PathVariable("groupId") Long groupId) {
		groupsProtectionService.removeVmsFromCG(vmId, groupId);
		backupApi.disableBackupForVmId(vmId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	private List<VmDefinition> getVmDefinitions(List<Object> vmObjects) {
		List<VmDefinition> vmDefs = new LinkedList<VmDefinition>();
		for (Object obj : vmObjects) {
			Map<String, Object> currVmObj = (Map<String, Object>) obj;
			VmDefinition currVmDef = new VmDefinition(currVmObj.get("id")
					.toString(), currVmObj.get("name").toString());
			vmDefs.add(currVmDef);
		}
		return vmDefs;
	}

	private List<String> getVmIds(List<Object> vmObjects) {
		List<String> vmIds = new LinkedList<String>();
		for (Object obj : vmObjects) {
			Map<String, Object> currVmObj = (Map<String, Object>) obj;
			vmIds.add(currVmObj.get("id").toString());
		}
		return vmIds;
	}

}
