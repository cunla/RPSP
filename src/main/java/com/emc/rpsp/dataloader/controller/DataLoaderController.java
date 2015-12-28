package com.emc.rpsp.dataloader.controller;

import com.emc.rpsp.accounts.service.AccountService;
import com.emc.rpsp.dataloader.domain.InternalData;
import com.emc.rpsp.dataloader.service.DataLoaderService;
import com.emc.rpsp.packages.service.PackageDefinitionService;
import com.emc.rpsp.rpsystems.SystemConnectionInfoRepository;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.service.UserService;
import com.emc.rpsp.vms.service.VmOwnershipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class DataLoaderController {

	@Autowired
	private DataLoaderService dataLoaderService;
	
	@Autowired
	private SystemConnectionInfoRepository systemConnectionInfoRepository;
	
	@Autowired
	private PackageDefinitionService packageDefService;
	
	@Autowired
	private AccountService accountService;
		
	@Autowired 
	private UserService userService;
	
	@Autowired
	private VmOwnershipService vmOwnershipService;

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/data-loader/internal-data", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SystemSettings>> populateInternalData(
			@RequestBody List<Map<String, Object>> fullSettings) {

		List<SystemSettings> createdSystemSettings = dataLoaderService
				.populateInternalData(fullSettings);
		return new ResponseEntity<>(createdSystemSettings, HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/data-loader/internal-data/template", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getFullConfigurationTemplate() {

		String template = dataLoaderService.getInternalDataTemplate();
		return new ResponseEntity<>(template, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/internal-data", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SystemSettings>> populateInternalData(
			@RequestBody InternalData internalData) {

		List<SystemSettings> createdSystemSettings = null;
		return new ResponseEntity<>(createdSystemSettings, HttpStatus.CREATED);
	}
	

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/internal-data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InternalData> getInternalData() {
		InternalData internalData = new InternalData();
		internalData.setSystems(systemConnectionInfoRepository.findAll());
		internalData.setPackages(packageDefService.findAll());
		internalData.setTenants(accountService.findAll());
		internalData.setUsers(userService.findUsers());
		internalData.setVms(vmOwnershipService.findAll());
		return new ResponseEntity<>(internalData, HttpStatus.OK);
	}

}
