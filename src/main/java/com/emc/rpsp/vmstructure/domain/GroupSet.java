package com.emc.rpsp.vmstructure.domain;

import java.util.LinkedList;
import java.util.List;

public class GroupSet implements VmContainer {

    private String id;
    private String name;
    private List<VmContainer> consistencyGroups = new LinkedList<VmContainer>();

    public GroupSet() {
        super();
    }

    public GroupSet(String name, List<VmContainer> consistencyGroups) {
        super();
        this.name = name;
        this.consistencyGroups = consistencyGroups;
    }

    public void addConsistencyGroup(VmContainer vmContainer) {
        consistencyGroups.add(vmContainer);
    }

    @Override public String getType() {
        return "gs";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VmContainer> getConsistencyGroups() {
        return consistencyGroups;
    }

    public void setConsistencyGroups(List<VmContainer> consistencyGroups) {
        this.consistencyGroups = consistencyGroups;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
