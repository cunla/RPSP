package com.emc.rpsp.bookmarks.service;



public interface GroupSetBookmarksService {
	public void createGroupSetBookmark(Long groupSetId, String bookmarkName, String consistencyType);
}
