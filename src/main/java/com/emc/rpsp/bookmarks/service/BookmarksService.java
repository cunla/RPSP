package com.emc.rpsp.bookmarks.service;



public interface BookmarksService {
	public void createGroupBookmark(Long groupId, String bookmarkName, String consistencyType);
}
