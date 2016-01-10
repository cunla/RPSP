package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("FullRecoverPointContext")
@XmlType(name = "FullRecoverPointContext")
////@LargeObject
public class FullRecoverPointContext extends FunctionalAPIContext {

    private FullRecoverPointSettingsContext fullSettingsContext;
    private FullRecoverPointStateContext fullStateContext;
    @XmlElement(nillable = true)
    private SystemStatusContext systemStatusContext;
    private HashSet<ClusterSANVolumesContext> clustersSANVolumesContexts;
    private HashSet<ClariionVolumesContext> clustersClariionVolumesContexts;
    private HashSet<VCenterServerViewContext> clustersVCentersServersContexts;
    /*private HashSet<ClusterFileSystemViewContext> clustersFileSystemViewContexts;*/ //XXX Vnx

    public FullRecoverPointContext() {
    }

    public FullRecoverPointContext(long globalContext, FullRecoverPointSettingsContext fullSettingsContext,
                                   FullRecoverPointStateContext fullStateContext, SystemStatusContext systemStatusContext,
                                   HashSet<ClusterSANVolumesContext> clustersSANVolumesContexts, HashSet<ClariionVolumesContext> clustersClariionVolumesContexts,
                                   HashSet<VCenterServerViewContext> clustersVCentersServersContexts) {
        super(globalContext);
        this.fullSettingsContext = fullSettingsContext;
        this.fullStateContext = fullStateContext;
        this.systemStatusContext = systemStatusContext;
        this.clustersSANVolumesContexts = clustersSANVolumesContexts;
        this.clustersClariionVolumesContexts = clustersClariionVolumesContexts;
        this.clustersVCentersServersContexts = clustersVCentersServersContexts;
    }

    public FullRecoverPointSettingsContext getFullSettingsContext() {
        return fullSettingsContext;
    }

    public void setFullSettingsContext(FullRecoverPointSettingsContext fullSettingsContext) {
        this.fullSettingsContext = fullSettingsContext;
    }

    public FullRecoverPointStateContext getFullStateContext() {
        return fullStateContext;
    }

    public void setFullStateContext(FullRecoverPointStateContext fullStateContext) {
        this.fullStateContext = fullStateContext;
    }

    public SystemStatusContext getSystemStatusContext() {
        return systemStatusContext;
    }

    public void setSystemStatusContext(SystemStatusContext systemStatusContext) {
        this.systemStatusContext = systemStatusContext;
    }

    public HashSet<ClusterSANVolumesContext> getClustersSANVolumesContexts() {
        return clustersSANVolumesContexts;
    }

    public void setClustersSANVolumesContexts(HashSet<ClusterSANVolumesContext> clustersSANVolumesContexts) {
        this.clustersSANVolumesContexts = clustersSANVolumesContexts;
    }

    public HashSet<ClariionVolumesContext> getClustersClariionVolumesContexts() {
        return clustersClariionVolumesContexts;
    }

    public void setClustersClariionVolumesContexts(HashSet<ClariionVolumesContext> clustersClariionVolumesContexts) {
        this.clustersClariionVolumesContexts = clustersClariionVolumesContexts;
    }

    public HashSet<VCenterServerViewContext> getClustersVCentersServersContexts() {
        return clustersVCentersServersContexts;
    }

    public void setClustersVCentersServersContexts(HashSet<VCenterServerViewContext> clustersVCentersServersContexts) {
        this.clustersVCentersServersContexts = clustersVCentersServersContexts;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FullRecoverPointContext [fullSettingsContext=")
            .append(fullSettingsContext).append(", fullStateContext=")
            .append(fullStateContext).append(", systemStatusContext=")
            .append(systemStatusContext)
            .append(", clustersSANVolumesContexts=")
            .append(clustersSANVolumesContexts)
            .append(", clustersClariionVolumesContexts=")
            .append(clustersClariionVolumesContexts)
            .append(", clustersVCentersServersContexts=")
            .append(clustersVCentersServersContexts).append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((fullSettingsContext == null) ? 0 : fullSettingsContext
            .hashCode());
        result = prime
            * result
            + ((fullStateContext == null) ? 0 : fullStateContext.hashCode());
        result = prime
            * result
            + ((clustersClariionVolumesContexts == null) ? 0
            : clustersClariionVolumesContexts.hashCode());
        result = prime
            * result
            + ((clustersSANVolumesContexts == null) ? 0
            : clustersSANVolumesContexts.hashCode());
        result = prime
            * result
            + ((clustersVCentersServersContexts == null) ? 0
            : clustersVCentersServersContexts.hashCode());
        result = prime
            * result
            + ((systemStatusContext == null) ? 0 : systemStatusContext
            .hashCode());
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
        FullRecoverPointContext other = (FullRecoverPointContext) obj;
        if (fullSettingsContext == null) {
            if (other.fullSettingsContext != null)
                return false;
        } else if (!fullSettingsContext.equals(other.fullSettingsContext))
            return false;
        if (fullStateContext == null) {
            if (other.fullStateContext != null)
                return false;
        } else if (!fullStateContext.equals(other.fullStateContext))
            return false;
        if (clustersClariionVolumesContexts == null) {
            if (other.clustersClariionVolumesContexts != null)
                return false;
        } else if (!clustersClariionVolumesContexts
            .equals(other.clustersClariionVolumesContexts))
            return false;
        if (clustersSANVolumesContexts == null) {
            if (other.clustersSANVolumesContexts != null)
                return false;
        } else if (!clustersSANVolumesContexts
            .equals(other.clustersSANVolumesContexts))
            return false;
        if (clustersVCentersServersContexts == null) {
            if (other.clustersVCentersServersContexts != null)
                return false;
        } else if (!clustersVCentersServersContexts
            .equals(other.clustersVCentersServersContexts))
            return false;
        if (systemStatusContext == null) {
            if (other.systemStatusContext != null)
                return false;
        } else if (!systemStatusContext.equals(other.systemStatusContext))
            return false;
        return true;
    }
}
