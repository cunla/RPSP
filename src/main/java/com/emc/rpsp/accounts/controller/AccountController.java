package com.emc.rpsp.accounts.controller;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.accounts.domain.AccountConfig;
import com.emc.rpsp.accounts.service.AccountService;
import com.emc.rpsp.repository.SystemConnectionInfoRepository;
import com.emc.rpsp.rpsystems.SystemSettings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller public class AccountController {

    @Autowired private AccountService accountService;

    @Autowired private SystemConnectionInfoRepository systemConnectionInfoRepository;

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/accounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public ResponseEntity<List<Account>> findAccounts() {
        List<Account> accounts = accountService.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')") @RequestMapping(value = "/accounts", params = {
    "systemId" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public ResponseEntity<List<Account>> findSystemAccounts(
    @RequestParam("systemId") Long systemId) {
        SystemSettings systemSettings = systemConnectionInfoRepository.findOne(systemId);
        if (systemSettings == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Account> accounts = systemSettings.getAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public ResponseEntity<Account> findAccount(@PathVariable("id") Long id) {
        Account account = accountService.findById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')") @RequestMapping(value = "/accounts", params = {
    "systemId" }, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> createAccount(@RequestBody Account account,
    @RequestParam("systemId") Long systemId) {
        Account sameAccount = accountService.findByName(account.getName());
        if (sameAccount != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        Account createdAccount = accountService.create(account, systemId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.LOCATION,
        "accounts/system/" + systemId + "/account/" + createdAccount.getId());
        return new ResponseEntity<>(createdAccount, httpHeaders, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public ResponseEntity<Account> updateAccount(@RequestBody Account account,
    @PathVariable("id") Long id) {
        Account existingAccount = accountService.findById(id);
        if (existingAccount == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Account sameAccount = accountService.findByName(account.getName());
        if (sameAccount != null && sameAccount.getId() != existingAccount.getId()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        account.setId(id);
        Account updatedAccount = accountService.update(account);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.DELETE) 
    @ResponseBody
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("id") Long id) {
        Account account = accountService.findById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accountService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    

}
