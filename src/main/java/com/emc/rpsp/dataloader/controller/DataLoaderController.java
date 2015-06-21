package com.emc.rpsp.dataloader.controller;

import com.emc.rpsp.dataloader.service.DataLoaderService;
import com.emc.rpsp.rpsystems.SystemSettings;
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

@Controller public class DataLoaderController {

    @Autowired private DataLoaderService dataLoaderService;

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

}
