package com.emc.rpsp.vmstructure.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AccountVmsStructure {

    private String id;
    private String name;
    private Boolean backupActive = true;
    private Boolean isAdmin = false;
    private SystemInfo systemInfo;
    private List<VmDefinition> unprotectedVms;
    private List<VmContainer> protectedVms;
    private List<GroupSet> groupSets = new ArrayList<GroupSet>();

    public AccountVmsStructure() {
        super();
        unprotectedVms = new LinkedList<VmDefinition>();
        protectedVms = new LinkedList<VmContainer>();
    }

    public AccountVmsStructure(String id, String name, List<VmDefinition> unprotectedVms,
                               List<VmContainer> protectedVms) {
        super();
        this.id = id;
        this.name = name;
        this.unprotectedVms = unprotectedVms;
        this.protectedVms = protectedVms;
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

    public List<VmDefinition> getUnprotectedVms() {
        return unprotectedVms;
    }

    public void setUnprotectedVms(List<VmDefinition> unprotectedVms) {
        this.unprotectedVms = unprotectedVms;
    }

    public List<VmContainer> getProtectedVms() {
        return protectedVms;
    }

    public void setProtectedVms(List<VmContainer> protectedVms) {
        this.protectedVms = protectedVms;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo systemInfo) {
        this.systemInfo = systemInfo;
    }

    public Boolean getBackupActive() {
        return backupActive;
    }

    public void setBackupActive(Boolean backupActive) {
        this.backupActive = backupActive;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

	public List<GroupSet> getGroupSets() {
		return groupSets;
	}

	public void setGroupSets(List<GroupSet> groupSets) {
		this.groupSets = groupSets;
	}
	
	public void add(GroupSet groupSet){
		groupSets.add(groupSet);
	}
    
    
}
