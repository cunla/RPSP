package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

@JsonTypeName("FullRecoverPointSettingsContext")
@XmlType(name = "FullRecoverPointSettingsContext")
public class FullRecoverPointSettingsContext extends FunctionalAPIContext {

    private long settingsConflictContext;

    public FullRecoverPointSettingsContext() {
    }

    public FullRecoverPointSettingsContext(long globalContext, long settingsConflictContext) {
        super(globalContext);
        this.settingsConflictContext = settingsConflictContext;
    }

    public long getSettingsConflictContext() {
        return settingsConflictContext;
    }

    public void setSettingsConflictContext(long settingsConflictContext) {
        this.settingsConflictContext = settingsConflictContext;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + (int) (settingsConflictContext ^ (settingsConflictContext >>> 32));
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
        FullRecoverPointSettingsContext other = (FullRecoverPointSettingsContext) obj;
        if (settingsConflictContext != other.settingsConflictContext)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FullRecoverPointSettingsContext [settingsConflictContext=").append(settingsConflictContext).
            append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
