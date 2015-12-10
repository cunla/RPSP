package com.emc.rpsp.recover.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emc.rpsp.recover.service.GroupCopiesRecoverService;

@Controller
public class GroupCopiesRecoverController {

	@Autowired
	private GroupCopiesRecoverService recoverService;

	@RequestMapping(value = "/groups/{groupId}/clusters/{clusterId}/copies/{copyId}/recover-production", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@RpspAudited(action = AuditConsts.RECOVER_PRODUCTION)
	@ResponseBody
	public @RpspAuditResult(AuditConsts.RECOVER_PRODUCTION_RESULT) ResponseEntity<HttpStatus> failover(
			@RpspAuditObject(AuditConsts.CLUSTER) @PathVariable("clusterId") Long clusterId,
			@RpspAuditSubject(AuditConsts.CG) @PathVariable("groupId") Long groupId,
			@PathVariable("copyId") Integer copyId) {
		recoverService.recoverProduction(clusterId, groupId, copyId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
