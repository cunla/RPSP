package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement

@JsonTypeName("ClariionSplitterSettings")
@XmlType(name = "ClariionSplitterSettings")
public class ClariionSplitterSettings extends ArrayBasedSplitterSettings {

    private SplitterCredentialsStatus credentialsStatus;
    private ClariionSplitterCredentials credentials;

    public ClariionSplitterSettings() {
    }

    public ClariionSplitterSettings(SplitterUID splitterUID, String splitterName,
                                    HashSet<AttachedUserVolumeInfo> attachedUserVolumes, boolean autoRegisterRPAsInitiators,
                                    SplitterCredentialsStatus credentialsStatus, ClariionSplitterCredentials credentials, ArrayUID arrayUID) {
        super(splitterUID, splitterName, attachedUserVolumes, autoRegisterRPAsInitiators, arrayUID);
        this.credentialsStatus = credentialsStatus;
        this.credentials = credentials;
    }

    public SplitterCredentialsStatus getCredentialsStatus() {
        return credentialsStatus;
    }

    public void setCredentialsStatus(SplitterCredentialsStatus credentialsStatus) {
        this.credentialsStatus = credentialsStatus;
    }

    public ClariionSplitterCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(ClariionSplitterCredentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((credentials == null) ? 0 : credentials.hashCode());
        result = prime
            * result
            + ((credentialsStatus == null) ? 0 : credentialsStatus
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
        ClariionSplitterSettings other = (ClariionSplitterSettings) obj;
        if (credentials == null) {
            if (other.credentials != null)
                return false;
        } else if (!credentials.equals(other.credentials))
            return false;
        if (credentialsStatus == null) {
            if (other.credentialsStatus != null)
                return false;
        } else if (!credentialsStatus.equals(other.credentialsStatus))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClariionSplitterSettings [credentials=").append(
            credentials).append(", credentialsStatus=").append(
            credentialsStatus).append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
