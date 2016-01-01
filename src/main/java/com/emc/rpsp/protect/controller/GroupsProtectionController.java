package com.emc.rpsp.protect.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.emc.rpsp.config.auditing.AuditConsts;
import com.emc.rpsp.config.auditing.annotations.RpspAuditObject;
import com.emc.rpsp.config.auditing.annotations.RpspAuditResult;
import com.emc.rpsp.config.auditing.annotations.RpspAuditSubject;
import com.emc.rpsp.config.auditing.annotations.RpspAudited;

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
	@RpspAudited(action=AuditConsts.CREATE_CG)
	@ResponseBody
	public @RpspAuditResult(AuditConsts.CREATE_CG_RESULT) ResponseEntity<HttpStatus> createConsistencyGroup(
			@RpspAuditSubject(AuditConsts.CREATE_CG_SUBJ_PARAMS) @RpspAuditObject(AuditConsts.CREATE_CG_OBJ_PARAMS) @RequestBody Map<String, Object> params) {
		String groupName = params.get("groupName").toString();
		boolean startReplication = Boolean.parseBoolean(params.get("enableReplication").toString());
		long packageId = Long.parseLong(params.get("packageId").toString());
		List<Object> vmIdsObj = (List<Object>) params.get("vms");
		List<String> vmIds = new LinkedList<String>();
		vmIdsObj.forEach((obj) -> vmIds.add(String.valueOf(obj)));
		groupsProtectionService.createConsistencyGroup(groupName, vmIds, startReplication, packageId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/groups/{groupId}/vms", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@RpspAudited(action=AuditConsts.ADD_VM_TO_CG)
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
		groupsProtectionService.addVmToCG(params.get("id").toString(), groupId,
				isCritical, sequenceNumber);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/groups/{groupId}/vms/{vmId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@RpspAudited(action=AuditConsts.REMOVE_VM_FROM_CG)
	@ResponseBody
	public @RpspAuditResult(AuditConsts.REMOVE_VM_FROM_CG_RESULT) ResponseEntity<HttpStatus> removeVmsFromCG(
			@RpspAuditObject(AuditConsts.VM) @PathVariable("vmId") String vmId,
			@RpspAuditSubject(AuditConsts.CG) @PathVariable("groupId") Long groupId) {
		groupsProtectionService.removeVmsFromCG(vmId, groupId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
