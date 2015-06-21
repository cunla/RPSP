package com.emc.rpsp.vmstructure.domain;

import java.util.LinkedList;
import java.util.List;

public class ClusterDefinition {

    private String id;
    private String name;
    private List<GroupCopySettings> groupCopySettings = new LinkedList<GroupCopySettings>();

    public ClusterDefinition(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public void addGroupCopy(GroupCopySettings groupCopySetting) {
        groupCopySettings.add(groupCopySetting);
    }

    public boolean isExistingCopy(GroupCopySettings copySetting) {
        boolean res = false;
        for (GroupCopySettings currCopySettings : groupCopySettings) {
            if (currCopySettings.getId().equals(copySetting.getId())) {
                res = true;
            }
        }
        return res;
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

    public List<GroupCopySettings> getGroupCopySettings() {
        return groupCopySettings;
    }

    public void setGroupCopySettings(List<GroupCopySettings> groupCopySettings) {
        this.groupCopySettings = groupCopySettings;
    }

}
