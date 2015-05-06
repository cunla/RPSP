package com.emc.rpsp.vmstructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emc.rpsp.vmstructure.domain.AccountVmsStructure;
import com.emc.rpsp.vmstructure.service.AccountVmsStructureService;

@Controller
public class AccountVmsStructureController {

	@Autowired
	private AccountVmsStructureService accountVmsStructureService;


	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/account-vms/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<AccountVmsStructure> findUser(@PathVariable("id") String id) {
		AccountVmsStructure accountVmsStructure = accountVmsStructureService.getAccountVmsStrucure(id);
		return new ResponseEntity<>(accountVmsStructure, HttpStatus.OK);
	}

	

}
