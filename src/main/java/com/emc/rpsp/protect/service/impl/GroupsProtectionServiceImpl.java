package com.emc.rpsp.protect.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.protect.service.GroupsProtectionService;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.service.UserService;

@Service 
public class GroupsProtectionServiceImpl implements GroupsProtectionService {
	
	@Autowired 
	private UserService userService = null;

	@Override
	public void addVmToCG(String vmId, Long groupId, boolean isCritical, int sequenceNumber) {
		Account account = userService.findCurrentUser().getUser().getAccount();
        if (account != null) {
            SystemSettings system = account.getSystemSettings().get(0);
            Client client = new Client(system);
            client.addVmToCG(vmId, groupId, account);
            client.changeVmsPowerUpSequence(vmId, groupId, isCritical, sequenceNumber);
        }
	}

	@Override
	public void removeVmsFromCG(String vmId, Long groupId) {
		Account account = userService.findCurrentUser().getUser().getAccount();
        if (account != null) {
            SystemSettings system = account.getSystemSettings().get(0);
            Client client = new Client(system);
            client.removeVmsFromCG(vmId, groupId, account);
        }
		
	}

    

}
