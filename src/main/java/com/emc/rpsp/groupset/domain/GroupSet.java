package com.emc.rpsp.groupset.domain;

import java.util.List;

public class GroupSet {
	


	private String id;
	private String name;
	private List<String> groupsIds;
	
	public GroupSet() {
		super();
	}

	public GroupSet(String id, String name, List<String> groupsIds) {
		super();
		this.id = id;
		this.name = name;
		this.groupsIds = groupsIds;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getGroupsIds() {
		return groupsIds;
	}

	public void setGroupsIds(List<String> groupsIds) {
		this.groupsIds = groupsIds;
	}
	
	
	
}
