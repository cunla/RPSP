package com.emc.rpsp.failover.controller;

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

import com.emc.rpsp.failover.service.GroupCopiesFailoverService;

@Controller
public class GroupCopiesFailoverController {

	@Autowired
	private GroupCopiesFailoverService failoverService;

	@RequestMapping(value = "/groups/{groupId}/clusters/{clusterId}/copies/{copyId}/failover", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    @RpspAudited(action = AuditConsts.FAILOVER)
	public @RpspAuditResult(AuditConsts.FAILOVER_RESULT) ResponseEntity<HttpStatus> failover(
			@RpspAuditObject(AuditConsts.CLUSTER) @PathVariable("clusterId") Long clusterId,
			@RpspAuditSubject(AuditConsts.CG) @PathVariable("groupId") Long groupId,
			@PathVariable("copyId") Integer copyId) {
		failoverService.failOver(clusterId, groupId, copyId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
