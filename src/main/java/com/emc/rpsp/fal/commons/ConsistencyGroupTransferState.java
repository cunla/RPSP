package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupTransferState")
public class ConsistencyGroupTransferState {

    @XmlElement(nillable = true)
    private ConsistencyGroupUID consistencyGroupUID;
    @XmlElement(nillable = true)
    private TransferState transferState;
    private String groupName;
    private String sourceClusterName;

}
