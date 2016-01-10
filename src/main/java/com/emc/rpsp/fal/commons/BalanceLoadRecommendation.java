package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@XmlType(name = "BalanceLoadRecommendation")
public class BalanceLoadRecommendation implements Validateable {

    private String resultOutput;
    private String resultEvent;
    private HashSet<ConsistencyGroupBalanceLoadRecommendation> groupsRecommendation;

    public BalanceLoadRecommendation() {
    }

    public BalanceLoadRecommendation(String resultOutput, String resultEvent,
                                     HashSet<ConsistencyGroupBalanceLoadRecommendation> groupsRecommendation) {
        this.resultOutput = resultOutput;
        this.resultEvent = resultEvent;
        this.groupsRecommendation = groupsRecommendation;
    }

    public String getResultOutput() {
        return resultOutput;
    }

    public void setResultOutput(String resultOutput) {
        this.resultOutput = resultOutput;
    }

    public String getResultEvent() {
        return resultEvent;
    }

    public void setResultEvent(String resultEvent) {
        this.resultEvent = resultEvent;
    }

    public HashSet<ConsistencyGroupBalanceLoadRecommendation> getGroupsRecommendation() {
        return groupsRecommendation;
    }

    public void setGroupsRecommendation(
        HashSet<ConsistencyGroupBalanceLoadRecommendation> groupsRecommendation) {
        this.groupsRecommendation = groupsRecommendation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((groupsRecommendation == null) ? 0 : groupsRecommendation
            .hashCode());
        result = prime * result
            + ((resultEvent == null) ? 0 : resultEvent.hashCode());
        result = prime * result
            + ((resultOutput == null) ? 0 : resultOutput.hashCode());
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
        BalanceLoadRecommendation other = (BalanceLoadRecommendation) obj;
        if (groupsRecommendation == null) {
            if (other.groupsRecommendation != null)
                return false;
        } else if (!groupsRecommendation.equals(other.groupsRecommendation))
            return false;
        if (resultEvent == null) {
            if (other.resultEvent != null)
                return false;
        } else if (!resultEvent.equals(other.resultEvent))
            return false;
        if (resultOutput == null) {
            if (other.resultOutput != null)
                return false;
        } else if (!resultOutput.equals(other.resultOutput))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BalanceLoadRecommendation [groupsRecommendation=")
            .append(groupsRecommendation).append(", resultEvent=").append(
            resultEvent).append(", resultOutput=").append(
            resultOutput).append("]");
        return builder.toString();
    }

}
