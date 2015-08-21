package com.emc.rpsp.bookmarks.service.impl;

import org.springframework.stereotype.Service;

import com.emc.rpsp.bookmarks.service.GroupBookmarksService;
import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.fal.Client;

@Service
public class GroupBookmarksServiceImpl extends BaseServiceImpl implements GroupBookmarksService {
	

	@Override
	public void createGroupBookmark(Long groupId, String bookmarkName, String consistencyType) {
		
		Client client = getClient();
		if(client != null){
			client.createGroupBookmark(groupId, bookmarkName, consistencyType);
		}
		
	}

}
