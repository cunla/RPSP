package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@XmlType(name = "SystemAlertsSettings")
public class SystemAlertsSettings implements Validateable {

    private boolean enabled;
    private String senderEmailAddress;
    private boolean sendDailyInfoToEMCSupport;
    private HashSet<EmailFilterData> emailFilters;

    public SystemAlertsSettings() {
    }

    public SystemAlertsSettings(boolean enabled,
                                String senderEmailAddress, boolean sendDailyInfoToEMCSupport,
                                HashSet<EmailFilterData> emailFilters) {
        this.enabled = enabled;
        this.senderEmailAddress = senderEmailAddress;
        this.sendDailyInfoToEMCSupport = sendDailyInfoToEMCSupport;
        this.emailFilters = emailFilters;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSenderEmailAddress() {
        return senderEmailAddress;
    }

    public void setSenderEmailAddress(String senderEmailAddress) {
        this.senderEmailAddress = senderEmailAddress;
    }

    public boolean getSendDailyInfoToEMCSupport() {
        return sendDailyInfoToEMCSupport;
    }

    public void setSendDailyInfoToEMCSupport(boolean sendDailyInfoToEMCSupport) {
        this.sendDailyInfoToEMCSupport = sendDailyInfoToEMCSupport;
    }

    public HashSet<EmailFilterData> getEmailFilters() {
        return emailFilters;
    }

    public void setEmailFilters(HashSet<EmailFilterData> emailFilters) {
        this.emailFilters = emailFilters;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((emailFilters == null) ? 0 : emailFilters.hashCode());
        result = prime * result + (enabled ? 1231 : 1237);
        result = prime * result + (sendDailyInfoToEMCSupport ? 1231 : 1237);
        result = prime
            * result
            + ((senderEmailAddress == null) ? 0 : senderEmailAddress
            .hashCode());
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
        SystemAlertsSettings other = (SystemAlertsSettings) obj;
        if (emailFilters == null) {
            if (other.emailFilters != null)
                return false;
        } else if (!emailFilters.equals(other.emailFilters))
            return false;
        if (enabled != other.enabled)
            return false;
        if (sendDailyInfoToEMCSupport != other.sendDailyInfoToEMCSupport)
            return false;
        if (senderEmailAddress == null) {
            if (other.senderEmailAddress != null)
                return false;
        } else if (!senderEmailAddress.equals(other.senderEmailAddress))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SystemAlertsSettings [emailFilters=").append(
            emailFilters).append(", enabled=").append(enabled)
            .append(", sendDailyInfoToEMCSupport=").append(
            sendDailyInfoToEMCSupport).append(
            ", senderEmailAddress=").append(senderEmailAddress)
            .append("]");
        return builder.toString();
    }
}
