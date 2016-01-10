package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * A class describing the status of some FAPI (long) operation.
 *
 * @author dagano
 */
@XmlRootElement
@XmlType(name = "TransactionStatus")
public class TransactionStatus {

    private ExecutionState state; // the state of execution
    private RecoverPointTimeStamp eta; // Estimated Time of Arrival (when will the transaction be finish)
    private Integer progressPercentage; // 0-100 progress

    private String title;
    private Integer stage;
    private Integer totalStages;
    private String completedStage;

    /**
     * default Ctor'
     */
    public TransactionStatus() {

    }

    public TransactionStatus(ExecutionState state, RecoverPointTimeStamp eta,
                             Integer progressPercentage, String title, Integer stage,
                             Integer totalStages, String completedStage) {
        this.state = state;
        this.eta = eta;
        this.progressPercentage = progressPercentage;
        this.title = title;
        this.stage = stage;
        this.totalStages = totalStages;
        this.completedStage = completedStage;
    }

    /**
     * @param state
     * @param eta      milis from midnight, January 1, 1970 UTC
     * @param progress 0-1 progress
     */
    public TransactionStatus(ExecutionState state, long eta, double progress) {
        this.state = state;
        this.eta = new RecoverPointTimeStamp(eta * 1000); // system time is in micros
        this.progressPercentage = (int) (progress * 100);
    }

    public ExecutionState getState() {
        return state;
    }

    public void setState(ExecutionState state) {
        this.state = state;
    }

    public RecoverPointTimeStamp getEta() {
        return eta;
    }

    public void setEta(RecoverPointTimeStamp eta) {
        this.eta = eta;
    }

    public Integer getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(Integer progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public Integer getTotalStages() {
        return totalStages;
    }

    public void setTotalStages(Integer totalStages) {
        this.totalStages = totalStages;
    }

    public String getCompletedStage() {
        return completedStage;
    }

    public void setCompletedStage(String completedStage) {
        this.completedStage = completedStage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((completedStage == null) ? 0 : completedStage.hashCode());
        result = prime * result + ((eta == null) ? 0 : eta.hashCode());
        result = prime
            * result
            + ((progressPercentage == null) ? 0 : progressPercentage
            .hashCode());
        result = prime * result + ((stage == null) ? 0 : stage.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result
            + ((totalStages == null) ? 0 : totalStages.hashCode());
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
        TransactionStatus other = (TransactionStatus) obj;
        if (completedStage == null) {
            if (other.completedStage != null)
                return false;
        } else if (!completedStage.equals(other.completedStage))
            return false;
        if (eta == null) {
            if (other.eta != null)
                return false;
        } else if (!eta.equals(other.eta))
            return false;
        if (progressPercentage == null) {
            if (other.progressPercentage != null)
                return false;
        } else if (!progressPercentage.equals(other.progressPercentage))
            return false;
        if (stage == null) {
            if (other.stage != null)
                return false;
        } else if (!stage.equals(other.stage))
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (totalStages == null) {
            if (other.totalStages != null)
                return false;
        } else if (!totalStages.equals(other.totalStages))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TransactionStatus [completedStage=").append(
            completedStage).append(", eta=").append(eta).append(
            ", progressPercentage=").append(progressPercentage).append(
            ", stage=").append(stage).append(", state=").append(state)
            .append(", title=").append(title).append(", totalStages=")
            .append(totalStages).append("]");
        return builder.toString();
    }

}
