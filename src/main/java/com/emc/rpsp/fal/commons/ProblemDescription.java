package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "ProblemDescription")
public class ProblemDescription {

    private int problemID;
    private String description;
    private ProblemSeverity severity;
    private ProblemCategory category;
    private SplitterUID relevantSplitter;
    private ClusterUID cluster;
    private HashSet<RpaUID> relevantRPAs;
    private HashSet<GlobalLinkUID> relevantGlobalLinks;
    private HashSet<ConsistencyGroupCopyUID> relevantCopies;
    private HashSet<DeviceUID> relevantDevices;
    private HashSet<SplitterVolumeInfo> relevantSplitterVolumesInformation;

    public ProblemDescription() {
    }

    public ProblemDescription(int problemID, String description, ProblemSeverity severity, ProblemCategory category,
                              SplitterUID relevantSplitter, ClusterUID cluster, HashSet<RpaUID> relevantRPAs, HashSet<GlobalLinkUID> relevantGlobalLinks,
                              HashSet<ConsistencyGroupCopyUID> relevantCopies, HashSet<DeviceUID> relevantDevices,
                              HashSet<SplitterVolumeInfo> relevantSplitterVolumesInformation) {
        this.problemID = problemID;
        this.description = description;
        this.severity = severity;
        this.category = category;
        this.relevantSplitter = relevantSplitter;
        this.cluster = cluster;
        this.relevantRPAs = relevantRPAs;
        this.relevantGlobalLinks = relevantGlobalLinks;
        this.relevantCopies = relevantCopies;
        this.relevantDevices = relevantDevices;
        this.relevantSplitterVolumesInformation = relevantSplitterVolumesInformation;
    }

    public int getProblemID() {
        return problemID;
    }

    public void setProblemID(int problemID) {
        this.problemID = problemID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProblemSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(ProblemSeverity severity) {
        this.severity = severity;
    }

    public ProblemCategory getCategory() {
        return category;
    }

    public void setCategory(ProblemCategory category) {
        this.category = category;
    }

    public SplitterUID getRelevantSplitter() {
        return relevantSplitter;
    }

    public void setRelevantSplitter(SplitterUID relevantSplitter) {
        this.relevantSplitter = relevantSplitter;
    }

    public ClusterUID getCluster() {
        return cluster;
    }

    public void setCluster(ClusterUID cluster) {
        this.cluster = cluster;
    }

    public HashSet<RpaUID> getRelevantRPAs() {
        return relevantRPAs;
    }

    public void setRelevantRPAs(HashSet<RpaUID> relevantRPAs) {
        this.relevantRPAs = relevantRPAs;
    }

    public HashSet<GlobalLinkUID> getRelevantGlobalLinks() {
        return relevantGlobalLinks;
    }

    public void setRelevantGlobalLinks(HashSet<GlobalLinkUID> relevantGlobalLinks) {
        this.relevantGlobalLinks = relevantGlobalLinks;
    }

    public HashSet<ConsistencyGroupCopyUID> getRelevantCopies() {
        return relevantCopies;
    }

    public void setRelevantCopies(HashSet<ConsistencyGroupCopyUID> relevantCopies) {
        this.relevantCopies = relevantCopies;
    }

    public HashSet<DeviceUID> getRelevantDevices() {
        return relevantDevices;
    }

    public void setRelevantDevices(HashSet<DeviceUID> relevantDevices) {
        this.relevantDevices = relevantDevices;
    }

    public HashSet<SplitterVolumeInfo> getRelevantSplitterVolumesInformation() {
        return relevantSplitterVolumesInformation;
    }

    public void setRelevantSplitterVolumesInformation(
        HashSet<SplitterVolumeInfo> relevantSplitterVolumesInformation) {
        this.relevantSplitterVolumesInformation = relevantSplitterVolumesInformation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((category == null) ? 0 : category.hashCode());
        result = prime * result
            + ((description == null) ? 0 : description.hashCode());
        result = prime * result + problemID;
        result = prime * result
            + ((relevantCopies == null) ? 0 : relevantCopies.hashCode());
        result = prime * result
            + ((relevantDevices == null) ? 0 : relevantDevices.hashCode());
        result = prime
            * result
            + ((relevantGlobalLinks == null) ? 0 : relevantGlobalLinks
            .hashCode());
        result = prime * result
            + ((relevantRPAs == null) ? 0 : relevantRPAs.hashCode());
        result = prime
            * result
            + ((relevantSplitter == null) ? 0 : relevantSplitter.hashCode());
        result = prime
            * result
            + ((relevantSplitterVolumesInformation == null) ? 0
            : relevantSplitterVolumesInformation.hashCode());
        result = prime * result
            + ((severity == null) ? 0 : severity.hashCode());
        result = prime * result + ((cluster == null) ? 0 : cluster.hashCode());
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
        ProblemDescription other = (ProblemDescription) obj;
        if (category != other.category)
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (problemID != other.problemID)
            return false;
        if (relevantCopies == null) {
            if (other.relevantCopies != null)
                return false;
        } else if (!relevantCopies.equals(other.relevantCopies))
            return false;
        if (relevantDevices == null) {
            if (other.relevantDevices != null)
                return false;
        } else if (!relevantDevices.equals(other.relevantDevices))
            return false;
        if (relevantGlobalLinks == null) {
            if (other.relevantGlobalLinks != null)
                return false;
        } else if (!relevantGlobalLinks.equals(other.relevantGlobalLinks))
            return false;
        if (relevantRPAs == null) {
            if (other.relevantRPAs != null)
                return false;
        } else if (!relevantRPAs.equals(other.relevantRPAs))
            return false;
        if (relevantSplitter == null) {
            if (other.relevantSplitter != null)
                return false;
        } else if (!relevantSplitter.equals(other.relevantSplitter))
            return false;
        if (relevantSplitterVolumesInformation == null) {
            if (other.relevantSplitterVolumesInformation != null)
                return false;
        } else if (!relevantSplitterVolumesInformation
            .equals(other.relevantSplitterVolumesInformation))
            return false;
        if (severity != other.severity)
            return false;
        if (cluster == null) {
            if (other.cluster != null)
                return false;
        } else if (!cluster.equals(other.cluster))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ProblemDescription [problemID=").append(problemID)
            .append(", description=").append(description)
            .append(", severity=").append(severity).append(", category=")
            .append(category).append(", relevantSplitter=")
            .append(relevantSplitter).append(", cluster=").append(cluster)
            .append(", relevantRPAs=").append(relevantRPAs)
            .append(", relevantGlobalLinks=").append(relevantGlobalLinks)
            .append(", relevantCopies=").append(relevantCopies)
            .append(", relevantDevices=").append(relevantDevices)
            .append(", relevantSplitterVolumesInformation=")
            .append(relevantSplitterVolumesInformation).append("]");
        return builder.toString();
    }
}
