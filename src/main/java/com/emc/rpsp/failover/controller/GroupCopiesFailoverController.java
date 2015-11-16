package com.emc.rpsp.failover.controller;

import com.emc.rpsp.config.auditing.Audited;
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
    @Audited
	public ResponseEntity<HttpStatus> failover(
			@PathVariable("clusterId") Long clusterId,
			@PathVariable("groupId") Long groupId,
			@PathVariable("copyId") Integer copyId) {
		failoverService.failOver(clusterId, groupId, copyId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
