package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlType(name = "ConsistencyGroupManagementSettings")
public class ConsistencyGroupManagementSettings implements Validateable {

    @XmlElement(nillable = true, required = true)
    private ManagementMode managementMode;
    @XmlElement(required = true)
    private ConsistencyGroupCopyUID recoveryCopy;
    private ConsistencyGroupCopyUID expectedActiveCopy;
    private boolean allowTestingWhileClustersDisconnected;
    private Snapshot recoveryImage;
    private RecoverPointTimeStamp recoveryImageExpiryDate;


}
