package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({VCenterServerViewContext.class, ClusterSANVolumesContext.class, FullRecoverPointSettingsContext.class, ClariionVolumesContext.class, SystemStatusContext.class, FullRecoverPointContext.class, FullRecoverPointStateContext.class, ClusterFileSystemViewContext.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = VCenterServerViewContext.class, name = "VCenterServerViewContext"),
    @Type(value = ClusterSANVolumesContext.class, name = "ClusterSANVolumesContext"),
    @Type(value = FullRecoverPointSettingsContext.class, name = "FullRecoverPointSettingsContext"),
    @Type(value = ClariionVolumesContext.class, name = "ClariionVolumesContext"),
    @Type(value = SystemStatusContext.class, name = "SystemStatusContext"),
    @Type(value = FullRecoverPointContext.class, name = "FullRecoverPointContext"),
    @Type(value = FullRecoverPointStateContext.class, name = "FullRecoverPointStateContext"),
    @Type(value = ClusterFileSystemViewContext.class, name = "ClusterFileSystemViewContext")})
public abstract
@XmlRootElement
class FunctionalAPIContext {

    protected long globalContext;

    public FunctionalAPIContext() {
    }

    public FunctionalAPIContext(long globalContext) {
        this.globalContext = globalContext;
    }

    public long getGlobalContext() {
        return globalContext;
    }

    public void setGlobalContext(long globalContext) {
        this.globalContext = globalContext;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + (int) (globalContext ^ (globalContext >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FunctionalAPIContext other = (FunctionalAPIContext) obj;
        if (globalContext != other.globalContext)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FunctionalAPIContext [globalContext=").append(
            globalContext).append("]");
        return builder.toString();
    }
}
