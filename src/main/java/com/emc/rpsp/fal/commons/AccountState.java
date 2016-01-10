package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Set;

@XmlRootElement
@XmlType(name = "AccountState")
public class AccountState {

    private Set<LicenseState> licensesState;

    public AccountState() {
    }

    public AccountState(Set<LicenseState> licesnesStats) {
        this.licensesState = licesnesStats;
    }

    public Set<LicenseState> getLicensesState() {
        return licensesState;
    }

    public void setLicensesState(Set<LicenseState> licesnesStats) {
        this.licensesState = licesnesStats;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((licensesState == null) ? 0 : licensesState.hashCode());
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
        AccountState other = (AccountState) obj;
        if (licensesState == null) {
            if (other.licensesState != null)
                return false;
        } else if (!licensesState.equals(other.licensesState))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AccountState [licensesState=").append(licensesState)
            .append("]");
        return builder.toString();
    }
}
