package com.emc.rpsp.imageaccess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.imageaccess.service.ImageAccessService;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.service.UserService;

@Service
public class ImageAccessServiceImpl implements ImageAccessService {
	
	@Autowired
	private UserService userService = null;

	

	@Override
	public void accessImage(Long clusterId, Long groupId) {
		Account account = userService.findCurrentUser().getUser().getAccount();
		if(account != null){
			SystemSettings system = account.getSystemSettings().get(0);
			Client client = new Client(system);
			client.enableImageAccess(clusterId, groupId);
		}
		
	}

}
