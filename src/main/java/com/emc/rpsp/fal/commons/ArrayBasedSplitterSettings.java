package com.emc.rpsp.fal.commons;

import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement

@XmlSeeAlso({ClariionSplitterSettings.class, SymmetrixSplitterSettings.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = ClariionSplitterSettings.class, name = "ClariionSplitterSettings"),
    @Type(value = SymmetrixSplitterSettings.class, name = "SymmetrixSplitterSettings")})
@JsonTypeName("ArrayBasedSplitterSettings")
@XmlType(name = "ArrayBasedSplitterSettings")
@NoArgsConstructor
public abstract class ArrayBasedSplitterSettings extends SplitterSettings {

    private boolean autoRegisterRPAsInitiators;

    public ArrayBasedSplitterSettings(SplitterUID splitterUID, String splitterName, HashSet<AttachedUserVolumeInfo> attachedUserVolumes,
                                      boolean autoRegisterRPAsInitiators, ArrayUID arrayUID) {
        super(splitterUID, splitterName, attachedUserVolumes, arrayUID);
        this.autoRegisterRPAsInitiators = autoRegisterRPAsInitiators;
    }

    public boolean getAutoRegisterRPAsInitiators() {
        return autoRegisterRPAsInitiators;
    }

    public void setAutoRegisterRPAsInitiators(boolean autoRegisterRPAsInitiators) {
        this.autoRegisterRPAsInitiators = autoRegisterRPAsInitiators;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (autoRegisterRPAsInitiators ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArrayBasedSplitterSettings other = (ArrayBasedSplitterSettings) obj;
        if (autoRegisterRPAsInitiators != other.autoRegisterRPAsInitiators)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ArrayBasedSplitterSettings [autoRegisterRPAsInitiators=")
            .append(autoRegisterRPAsInitiators).append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
