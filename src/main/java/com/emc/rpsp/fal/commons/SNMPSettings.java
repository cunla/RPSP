package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;


@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SNMPSettings")
public class SNMPSettings implements Validateable {

    private boolean agentEnabled;
    private boolean shouldSendEventTraps;
    private HashSet<SystemEventLogsFilterUID> sendEventFilters;
    private HashSet<SNMPTrapDestination> traps;
    @XmlElement(required = true)
    private String snmpCommunity;
    private HashSet<SNMPUser> users;
    private boolean secureTransportsOnly;

    public SNMPSettings() {
    }

    public SNMPSettings(boolean agentEnabled, boolean shouldSendEventTraps, HashSet<SystemEventLogsFilterUID> sendEventFilters,
                        HashSet<SNMPTrapDestination> traps, String snmpCommunity, HashSet<SNMPUser> users,
                        boolean secureTransportsOnly) {
        this.agentEnabled = agentEnabled;
        this.shouldSendEventTraps = shouldSendEventTraps;
        this.sendEventFilters = sendEventFilters;
        this.traps = traps;
        this.snmpCommunity = snmpCommunity;
        this.users = users;
        this.secureTransportsOnly = secureTransportsOnly;
    }

    public boolean getAgentEnabled() {
        return agentEnabled;
    }

    public void setAgentEnabled(boolean agentEnabled) {
        this.agentEnabled = agentEnabled;
    }

    public boolean getShouldSendEventTraps() {
        return shouldSendEventTraps;
    }

    public void setShouldSendEventTraps(boolean shouldSendEventTraps) {
        this.shouldSendEventTraps = shouldSendEventTraps;
    }

    public HashSet<SystemEventLogsFilterUID> getSendEventFilters() {
        return sendEventFilters;
    }

    public void setSendEventFilters(
        HashSet<SystemEventLogsFilterUID> sendEventFilters) {
        this.sendEventFilters = sendEventFilters;
    }

    public HashSet<SNMPTrapDestination> getTraps() {
        return traps;
    }

    public void setTraps(HashSet<SNMPTrapDestination> traps) {
        this.traps = traps;
    }

    public String getSnmpCommunity() {
        return snmpCommunity;
    }

    public void setSnmpCommunity(String snmpCommunity) {
        this.snmpCommunity = snmpCommunity;
    }

    public HashSet<SNMPUser> getUsers() {
        return users;
    }

    public void setUsers(HashSet<SNMPUser> users) {
        this.users = users;
    }

    public boolean isSecureTransportsOnly() {
        return secureTransportsOnly;
    }

    public void setSecureTransportsOnly(boolean secureTransportsOnly) {
        this.secureTransportsOnly = secureTransportsOnly;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (agentEnabled ? 1231 : 1237);
        result = prime * result + (secureTransportsOnly ? 1231 : 1237);
        result = prime
            * result
            + ((sendEventFilters == null) ? 0 : sendEventFilters.hashCode());
        result = prime * result + (shouldSendEventTraps ? 1231 : 1237);
        result = prime * result
            + ((snmpCommunity == null) ? 0 : snmpCommunity.hashCode());
        result = prime * result + ((traps == null) ? 0 : traps.hashCode());
        result = prime * result + ((users == null) ? 0 : users.hashCode());
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
        SNMPSettings other = (SNMPSettings) obj;
        if (agentEnabled != other.agentEnabled)
            return false;
        if (secureTransportsOnly != other.secureTransportsOnly)
            return false;
        if (sendEventFilters == null) {
            if (other.sendEventFilters != null)
                return false;
        } else if (!sendEventFilters.equals(other.sendEventFilters))
            return false;
        if (shouldSendEventTraps != other.shouldSendEventTraps)
            return false;
        if (snmpCommunity == null) {
            if (other.snmpCommunity != null)
                return false;
        } else if (!snmpCommunity.equals(other.snmpCommunity))
            return false;
        if (traps == null) {
            if (other.traps != null)
                return false;
        } else if (!traps.equals(other.traps))
            return false;
        if (users == null) {
            if (other.users != null)
                return false;
        } else if (!users.equals(other.users))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SNMPSettings [agentEnabled=").append(agentEnabled)
            .append(", shouldSendEventTraps=").append(shouldSendEventTraps)
            .append(", sendEventFilters=").append(sendEventFilters)
            .append(", traps=").append(traps).append(", snmpCommunity=")
            .append(snmpCommunity).append(", users=").append(users)
            .append(", secureTransportsOnly=").append(secureTransportsOnly)
            .append("]");
        return builder.toString();
    }

}
