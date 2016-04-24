package com.emc.rpsp.groupset.service;

import java.util.List;

import com.emc.rpsp.groupset.domain.GroupSet;



public interface GroupSetService {
	public void createGroupSet(GroupSet groupSet);
	public void removeGroupSet(GroupSet groupSet);
	public void updateGroupSet(GroupSet groupSet);
	public List<GroupSet> getGroupSets();
}
