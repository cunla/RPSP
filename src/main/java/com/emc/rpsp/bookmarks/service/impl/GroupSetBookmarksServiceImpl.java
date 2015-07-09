package com.emc.rpsp.bookmarks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.bookmarks.service.GroupSetBookmarksService;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.service.UserService;

@Service
public class GroupSetBookmarksServiceImpl implements GroupSetBookmarksService {
	
	@Autowired private UserService userService = null;


	
	@Override
	public void createGroupSetBookmark(Long groupSetId, String bookmarkName, String consistencyType){
		Account account = userService.findCurrentUser().getUser().getAccount();
        if (account != null) {
            SystemSettings system = account.getSystemSettings().get(0);
            Client client = new Client(system);
            client.createGroupSetBookmark(groupSetId, bookmarkName, consistencyType);
        }
	}

}
