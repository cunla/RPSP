package com.emc.rpsp.bookmarks.service.impl;

import org.springframework.stereotype.Service;

import com.emc.rpsp.bookmarks.service.GroupSetBookmarksService;
import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.fal.Client;

@Service
public class GroupSetBookmarksServiceImpl extends BaseServiceImpl implements GroupSetBookmarksService {
	


	
	@Override
	public void createGroupSetBookmark(Long groupSetId, String bookmarkName, String consistencyType){
		
		Client client = getClient();
		if(client != null){
			client.createGroupSetBookmark(groupSetId, bookmarkName, consistencyType);
		}
		
	}

}
