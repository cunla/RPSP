package com.emc.rpsp.groupset.service;

import java.util.List;

import com.emc.rpsp.vmstructure.domain.GroupSet;




public interface GroupSetService {
	public List<GroupSet> getAllGroupSets();	
	public void createGroupSet(GroupSet groupSet);
	public void updateGroupSet(GroupSet groupSet);
	public void removeGroupSet(String groupSetId);
}
