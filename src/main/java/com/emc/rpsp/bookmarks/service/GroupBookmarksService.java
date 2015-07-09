package com.emc.rpsp.bookmarks.service;



public interface GroupBookmarksService {
	public void createGroupBookmark(Long groupId, String bookmarkName, String consistencyType);
}
