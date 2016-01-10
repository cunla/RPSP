package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement

@JsonTypeName("SymmetrixSplitterSettings")
@XmlType(name = "SymmetrixSplitterSettings")
public class SymmetrixSplitterSettings extends ArrayBasedSplitterSettings {

    public SymmetrixSplitterSettings() {
        super();
    }

    public SymmetrixSplitterSettings(SplitterUID splitterUID, String splitterName, HashSet<AttachedUserVolumeInfo> attachedUserVolumes,
                                     boolean autoRegisterRPAsInitiators, ArrayUID arrayUID) {
        super(splitterUID, splitterName, attachedUserVolumes, autoRegisterRPAsInitiators, arrayUID);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("SymmetrixSplitterSettings [super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
