package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "FileSystemMatchingReplicas")
public class FileSystemMatchingReplicas {

    private FileSystemUID source;
    private HashSet<FileSystemInformation> matchingFileSystems;

    public FileSystemMatchingReplicas() {
    }

    public FileSystemMatchingReplicas(FileSystemUID source,
                                      HashSet<FileSystemInformation> matchingFileSystems) {
        this.source = source;
        this.matchingFileSystems = matchingFileSystems;
    }

    public FileSystemUID getSource() {
        return source;
    }

    public void setSource(FileSystemUID source) {
        this.source = source;
    }

    public HashSet<FileSystemInformation> getMatchingFileSystems() {
        return matchingFileSystems;
    }

    public void setMatchingFileSystems(
        HashSet<FileSystemInformation> matchingFileSystems) {
        this.matchingFileSystems = matchingFileSystems;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((matchingFileSystems == null) ? 0 : matchingFileSystems
            .hashCode());
        result = prime * result + ((source == null) ? 0 : source.hashCode());
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
        FileSystemMatchingReplicas other = (FileSystemMatchingReplicas) obj;
        if (matchingFileSystems == null) {
            if (other.matchingFileSystems != null)
                return false;
        } else if (!matchingFileSystems.equals(other.matchingFileSystems))
            return false;
        if (source == null) {
            if (other.source != null)
                return false;
        } else if (!source.equals(other.source))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FileSystemMatchingReplicas [source=")
            .append(source).append(", matchingFileSystems=")
            .append(matchingFileSystems).append("]");
        return builder.toString();
    }
}
