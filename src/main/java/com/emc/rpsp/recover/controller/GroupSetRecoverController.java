package com.emc.rpsp.recover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emc.rpsp.recover.service.GroupSetRecoverService;

@Controller
public class GroupSetRecoverController {

	@Autowired
	private GroupSetRecoverService recoverService;

	@RequestMapping(value = "/group-sets/{groupSetId}/clusters/{clusterId}/recover-production", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<HttpStatus> failover(
			@PathVariable("clusterId") Long clusterId,
			@PathVariable("groupSetId") Long groupSetId) {
		recoverService.recoverProduction(clusterId, groupSetId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
