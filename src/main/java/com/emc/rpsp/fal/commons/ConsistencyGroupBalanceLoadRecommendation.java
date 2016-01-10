package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupBalanceLoadRecommendation")
public class ConsistencyGroupBalanceLoadRecommendation implements Validateable {

    @XmlElement(required = true)
    private ConsistencyGroupUID groupUID;
    private int primaryRPANumber;
    private LinkedList<Integer> secondaryRPAsNumbers;

    public ConsistencyGroupBalanceLoadRecommendation() {
    }

    public ConsistencyGroupBalanceLoadRecommendation(ConsistencyGroupUID groupUID, int primaryRPANumber,
                                                     LinkedList<Integer> secondaryRPAsNumbers) {
        this.groupUID = groupUID;
        this.primaryRPANumber = primaryRPANumber;
        this.secondaryRPAsNumbers = secondaryRPAsNumbers;
    }

    public ConsistencyGroupUID getGroupUID() {
        return groupUID;
    }

    public void setGroupUID(ConsistencyGroupUID groupUID) {
        this.groupUID = groupUID;
    }

    public int getPrimaryRPANumber() {
        return primaryRPANumber;
    }

    public void setPrimaryRPANumber(int primaryRPANumber) {
        this.primaryRPANumber = primaryRPANumber;
    }

    public LinkedList<Integer> getSecondaryRPAsNumbers() {
        return secondaryRPAsNumbers;
    }

    public void setSecondaryRPAsNumbers(LinkedList<Integer> secondaryRPAsNumbers) {
        this.secondaryRPAsNumbers = secondaryRPAsNumbers;
    }

}
