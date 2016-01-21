package com.emc.rpsp.virtualconfig.controller;

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

import com.emc.rpsp.virtualconfig.domain.VcenterConfig;
import com.emc.rpsp.virtualconfig.service.VirtualConfigurationService;

@Controller
public class VirtualConfigurationController {

	@Autowired
	private VirtualConfigurationService virtualConfigurationService;

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/virtualconfig/clusters/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<VcenterConfig> findVirtualConfiguration(@PathVariable("id") Long id) {
		VcenterConfig vcenterConfig = virtualConfigurationService.getVirtualConfiguration(id);
		return new ResponseEntity<>(vcenterConfig, HttpStatus.OK);
	}

}
