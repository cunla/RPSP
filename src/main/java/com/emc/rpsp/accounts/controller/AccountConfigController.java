package com.emc.rpsp.accounts.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emc.rpsp.accounts.domain.AccountConfig;
import com.emc.rpsp.accounts.service.AccountConfigService;

@Controller public class AccountConfigController {

	
	
    @Autowired private AccountConfigService accountConfigService;
  
    
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/account-configs", params = {"accountId"}, 
                               method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public ResponseEntity<List<AccountConfig>> findAllAccountConfigs(@RequestParam("accountId") Long accountId) {
    	List<AccountConfig> accountsConfigs = accountConfigService.findAllAccountConfigs(accountId);
        return new ResponseEntity<>(accountsConfigs, HttpStatus.OK);
    }
    
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/account-configs/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public ResponseEntity<AccountConfig> findAccountConfig(@PathVariable("id") Long id) {
    	AccountConfig accountsConfig = accountConfigService.findAccountConfig(id);
        return new ResponseEntity<>(accountsConfig, HttpStatus.OK);
    }
    
    
    @PreAuthorize("hasAuthority('ADMIN')") @RequestMapping(value = "/account-configs", params = {"accountId"}, 
    		                  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountConfig> createAccountConfig(@RequestBody AccountConfig accountConfig,
    		@RequestParam("accountId") Long accountId) {
    	AccountConfig createdAccountConfig = accountConfigService.createAccountConfig(accountConfig, accountId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.LOCATION,
        "/account-configs/" + createdAccountConfig.getId());
        return new ResponseEntity<>(createdAccountConfig, httpHeaders, HttpStatus.CREATED);
    }
    
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/account-configs/{id}", method = RequestMethod.DELETE) 
    @ResponseBody
    public ResponseEntity<HttpStatus> deleteAccountConfig(@PathVariable("id") Long id) {
    	AccountConfig accountConfig = accountConfigService.findAccountConfig(id);
        if (accountConfig == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accountConfigService.deleteAccountConfig(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    

}
