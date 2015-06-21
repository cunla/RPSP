package com.emc.rpsp.vmstructure.controller;

import com.emc.rpsp.vmstructure.domain.AccountVmsStructure;
import com.emc.rpsp.vmstructure.service.AccountVmsStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller public class AccountVmsStructureController {

    @Autowired private AccountVmsStructureService accountVmsStructureService;

    @RequestMapping(value = "/account-vms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public ResponseEntity<AccountVmsStructure> findAccountVmsStructure() {
        AccountVmsStructure accountVmsStructure = accountVmsStructureService
        .getAccountVmsStrucure();
        return new ResponseEntity<>(accountVmsStructure, HttpStatus.OK);
    }

}
