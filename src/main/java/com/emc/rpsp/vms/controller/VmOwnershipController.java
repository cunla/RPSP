package com.emc.rpsp.vms.controller;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.accounts.service.AccountService;
import com.emc.rpsp.vms.domain.VmOwnership;
import com.emc.rpsp.vms.service.VmOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller public class VmOwnershipController {

    @Autowired private VmOwnershipService vmOwnershipService;

    @Autowired private AccountService accountService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/vmownership", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public ResponseEntity<List<VmOwnership>> findVms() {
        List<VmOwnership> vmownerships = vmOwnershipService.findAll();
        return new ResponseEntity<>(vmownerships, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')") @RequestMapping(value = "/vmownership", params = {
    "accountId" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public ResponseEntity<List<VmOwnership>> findAccountVms(
    @RequestParam("accountId") Long accountId) {
        Account account = accountService.findById(accountId);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<VmOwnership> accountVms = account.getVms();
        return new ResponseEntity<>(accountVms, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/vmownership/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public ResponseEntity<VmOwnership> findVm(@PathVariable("id") Long id) {
        VmOwnership vmownership = vmOwnershipService.findById(id);
        return new ResponseEntity<>(vmownership, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')") @RequestMapping(value = "/vmownership", params = {
    "accountId" }, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VmOwnership> createVm(@RequestBody VmOwnership vmOwnership,
    @RequestParam("accountId") Long accountId) {
        VmOwnership sameVmOwnership = vmOwnershipService.findByVmId(vmOwnership.getVmId());
        if (sameVmOwnership != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Account account = accountService.findById(accountId);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        VmOwnership createdVmOwnership = vmOwnershipService.create(vmOwnership, accountId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.LOCATION, "vmownerships/" + createdVmOwnership.getId());
        return new ResponseEntity<>(createdVmOwnership, httpHeaders, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/vmownership/{id}", method = RequestMethod.DELETE) @ResponseBody
    public ResponseEntity<HttpStatus> deleteVm(@PathVariable("id") Long id) {
        VmOwnership vmownership = vmOwnershipService.findById(id);
        if (vmownership == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        vmOwnershipService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
