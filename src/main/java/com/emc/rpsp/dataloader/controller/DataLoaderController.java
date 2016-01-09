package com.emc.rpsp.dataloader.controller;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.accounts.service.AccountService;
import com.emc.rpsp.dataloader.domain.InternalData;
import com.emc.rpsp.dataloader.service.DataLoaderService;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.packages.domain.PackageConfig;
import com.emc.rpsp.packages.domain.PackageDefinition;
import com.emc.rpsp.packages.service.PackageDefinitionService;
import com.emc.rpsp.rpsystems.ClusterSettings;
import com.emc.rpsp.rpsystems.SystemConnectionInfoRepository;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.domain.User;
import com.emc.rpsp.users.service.UserService;
import com.emc.rpsp.vms.domain.VmOwnership;
import com.emc.rpsp.vms.service.VmOwnershipService;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class DataLoaderController {

	@Autowired
	private DataLoaderService dataLoaderService;

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/internal-data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InternalData> getInternalData() {
		InternalData internalData = dataLoaderService.getInternalData();
		return new ResponseEntity<>(internalData, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/internal-data", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InternalData> populateInternalData(
			@RequestBody InternalData internalData) {
		InternalData res = dataLoaderService.populateInternalData(internalData);		
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
	

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/internal-data/template", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getFullConfigurationTemplate() {
		String template = dataLoaderService.getInternalDataTemplate();
		return new ResponseEntity<>(template, HttpStatus.OK);
	}
	


}
