package com.emc.rpsp.packages.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emc.rpsp.packages.domain.PackageDefinition;
import com.emc.rpsp.packages.service.PackageDefinitionService;
import com.emc.rpsp.rpsystems.SystemConnectionInfoRepository;

@Controller
public class PackageDefinitionController {

	@Autowired
	private PackageDefinitionService packageDefService;

	@Autowired
	private SystemConnectionInfoRepository systemConnectionInfoRepository;

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/packages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<PackageDefinition>> findPackages() {
		List<PackageDefinition> accounts = packageDefService.findAll();
		return new ResponseEntity<>(accounts, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/packages/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<PackageDefinition> findPackage(@PathVariable("id") Long id) {
		PackageDefinition account = packageDefService.findById(id);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/packages", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PackageDefinition> createPackage(@RequestBody PackageDefinition packageDef) {
		PackageDefinition createdPackageDef = packageDefService.create(packageDef);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.LOCATION,  "/packages/" + createdPackageDef.getId());
		return new ResponseEntity<>(createdPackageDef, httpHeaders,
				HttpStatus.CREATED);
	}


	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/packages/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<HttpStatus> deletePackage(@PathVariable("id") Long id) {
		PackageDefinition packageDef = packageDefService.findById(id);
		if (packageDef == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		packageDefService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	/*@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/packages", params = { "systemId" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Account>> findSystemPackages(
			@RequestParam("systemId") Long systemId) {
		SystemSettings systemSettings = systemConnectionInfoRepository
				.findOne(systemId);
		if (systemSettings == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<Account> accounts = systemSettings.getAccounts();
		return new ResponseEntity<>(accounts, HttpStatus.OK);
	}*/

}
