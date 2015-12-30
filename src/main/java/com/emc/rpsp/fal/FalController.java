package com.emc.rpsp.fal;

import com.emc.fapi.jaxws.v4_3.FullRecoverPointSettings;
import com.emc.rpsp.rpsystems.SystemConnectionInfoRepository;
import com.emc.rpsp.rpsystems.SystemSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
public class FalController {
    private final Logger log = LoggerFactory.getLogger(FalController.class);
    @Inject
    private SystemConnectionInfoRepository systemConnectionInfoRepository;

    //Meant to test ability to deserialise from fapi /settings
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/{id}/fapi/settings",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<FullRecoverPointSettings> systemSettings(@PathVariable("id") Long id) {
        SystemSettings systemSettings = systemConnectionInfoRepository.findOne(id);
        Client client = new Client(systemSettings);
        client.getSystemTime();
        FullRecoverPointSettings settings = client.getFullRecoverPointSettings();
        return new ResponseEntity<>(settings, HttpStatus.OK);
    }

}
