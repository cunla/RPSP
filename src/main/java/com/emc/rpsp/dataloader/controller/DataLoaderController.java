package com.emc.rpsp.dataloader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emc.rpsp.dataloader.domain.InternalData;
import com.emc.rpsp.dataloader.service.DataLoaderService;
import com.emc.rpsp.rpsystems.ClusterSettings;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.virtualconfig.domain.VcenterConfig;
import com.emc.rpsp.virtualconfig.service.VirtualConfigurationService;

@Controller
public class DataLoaderController {

	@Autowired
	private DataLoaderService dataLoaderService;
		
	@Autowired
	private VirtualConfigurationService virtualConfigurationService;
	

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/internal-data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InternalData> getInternalData(@RequestParam(value = "includeVirtualConfig", required=false, defaultValue = "false") Boolean includeVirtualConfig) {
		InternalData internalData = dataLoaderService.getInternalData();
		if(includeVirtualConfig){
			addVirtualConfigurationInfo(internalData.getSystems());
		}
		return new ResponseEntity<>(internalData, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/internal-data", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InternalData> populateInternalData(
			@RequestBody InternalData internalData) {
		InternalData res = dataLoaderService.populateInternalData(internalData);
		addVirtualConfigurationInfo(res.getSystems());
		
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
	

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/internal-data/template", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getFullConfigurationTemplate() {
		String template = dataLoaderService.getInternalDataTemplate();
		return new ResponseEntity<>(template, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/internal-data", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<HttpStatus> deleteInternalData() {
		dataLoaderService.deleteInternalData();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	private void addVirtualConfigurationInfo(List<SystemSettings> systemSettingsList){
		for(SystemSettings systemSettings : systemSettingsList){
			addVirtualConfigurationInfo(systemSettings);
		}
	}
	
	private void addVirtualConfigurationInfo(SystemSettings systemSettings){
		List<ClusterSettings> clusters = systemSettings.getClusters();
		for(ClusterSettings cluster : clusters){
			VcenterConfig vcenterConfig = virtualConfigurationService.getVirtualConfiguration(cluster.getClusterId());
			cluster.setVcenterConfig(vcenterConfig);
		}
	}


}
