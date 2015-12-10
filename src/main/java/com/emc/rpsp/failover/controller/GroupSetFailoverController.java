package com.emc.rpsp.failover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emc.rpsp.config.auditing.AuditConsts;
import com.emc.rpsp.config.auditing.annotations.RpspAuditObject;
import com.emc.rpsp.config.auditing.annotations.RpspAuditResult;
import com.emc.rpsp.config.auditing.annotations.RpspAuditSubject;
import com.emc.rpsp.config.auditing.annotations.RpspAudited;
import com.emc.rpsp.failover.service.GroupSetFailoverService;

@Controller
public class GroupSetFailoverController {

	@Autowired
	private GroupSetFailoverService failoverService;

	@RequestMapping(value = "/group-sets/{groupSetId}/clusters/{clusterId}/failover", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RpspAudited(action = AuditConsts.FAILOVER)
	public @RpspAuditResult(AuditConsts.FAILOVER_RESULT) ResponseEntity<HttpStatus> failover(
			@RpspAuditObject(AuditConsts.CLUSTER) @PathVariable("clusterId") Long clusterId,
			@RpspAuditSubject(AuditConsts.GS) @PathVariable("groupSetId") Long groupSetId) {
		failoverService.failoverGroupSetSubset(clusterId, groupSetId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
