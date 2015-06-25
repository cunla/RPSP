package com.emc.rpsp.protect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emc.rpsp.protect.service.ProtectService;

@Controller
public class ProtectController {

	@Autowired
	private ProtectService protectService;

	@RequestMapping(value = "/protect", params = { "vmId", "groupId" }, 
			method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<HttpStatus> addVmToCG(
			@RequestParam("vmId") String vmId,
			@RequestParam("groupId") Long groupId) {
		protectService.addVmToCG(vmId,  groupId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/unprotect", params = { "vmId", "groupId" }, 
			method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<HttpStatus> removeVmsFromCG(
			@RequestParam("vmId") String vmId,
			@RequestParam("groupId") Long groupId) {
		protectService.removeVmsFromCG(vmId,  groupId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
