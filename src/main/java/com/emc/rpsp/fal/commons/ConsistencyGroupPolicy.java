package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;

@SuppressWarnings("serial")
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupPolicy")
public class ConsistencyGroupPolicy implements Validateable {

    private int primaryRPANumber;
    private LinkedList<Integer> secondaryRPAsNumbers;
    private boolean reservationSupported;
    private boolean canTransferOnNonPreferredRPA;
    private Integer hostsDelayExpiryTimeoutInSeconds;
    private boolean distributedGroup;
    @XmlElement(nillable = true, required = true)
    private Priority priority;
    @XmlElement(required = true)
    private ConsistencyGroupManagementSettings managementSettings;
    private boolean readOnlyInReplicaVolumes;
    private ClusterUID preferedClusterUID;
    private Integer powerUp;

}
