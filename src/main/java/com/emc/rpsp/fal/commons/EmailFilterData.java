package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EmailFilterData")
public class EmailFilterData implements Validateable {

    @XmlElement(required = true)
    private LinkedList<String> targetAddressesList;
    @XmlElement(required = true)
    private SystemEventLogsFilterUID sendEventFilterID;
    @XmlElement(nillable = true, required = true)
    private AlertType alertType;

    public EmailFilterData() {
    }

    public EmailFilterData(LinkedList<String> targetAddressesList, SystemEventLogsFilterUID sendEventFilterID, AlertType alertType) {
        this.targetAddressesList = targetAddressesList;
        this.sendEventFilterID = sendEventFilterID;
        this.alertType = alertType;
    }

    public LinkedList<String> getTargetAddressesList() {
        return targetAddressesList;
    }

    public void setTargetAddressesList(LinkedList<String> targetAddressesList) {
        this.targetAddressesList = targetAddressesList;
    }

    public SystemEventLogsFilterUID getSendEventFilterID() {
        return sendEventFilterID;
    }

    public void setSendEventFilterID(SystemEventLogsFilterUID sendEventFilterID) {
        this.sendEventFilterID = sendEventFilterID;
    }

    public AlertType getAlertType() {
        return alertType;
    }

    public void setAlertType(AlertType alertType) {
        this.alertType = alertType;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((alertType == null) ? 0 : alertType.hashCode());
        result = prime
            * result
            + ((sendEventFilterID == null) ? 0 : sendEventFilterID
            .hashCode());
        result = prime
            * result
            + ((targetAddressesList == null) ? 0 : targetAddressesList
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
        EmailFilterData other = (EmailFilterData) obj;
        if (alertType == null) {
            if (other.alertType != null)
                return false;
        } else if (!alertType.equals(other.alertType))
            return false;
        if (sendEventFilterID == null) {
            if (other.sendEventFilterID != null)
                return false;
        } else if (!sendEventFilterID.equals(other.sendEventFilterID))
            return false;
        if (targetAddressesList == null) {
            if (other.targetAddressesList != null)
                return false;
        } else if (!targetAddressesList.equals(other.targetAddressesList))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EmailFilterData [alertType=").append(alertType).append(
            ", sendEventFilterID=").append(sendEventFilterID).append(
            ", targetAddressesList=").append(targetAddressesList).append(
            "]");
        return builder.toString();
    }
}
