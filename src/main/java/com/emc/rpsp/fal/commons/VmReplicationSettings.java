package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmReplicationSettings")
public class VmReplicationSettings {

    @XmlElement(nillable = true)
    private VmUID vmUID;
    private ConsistencyGroupCopyUID groupCopyUID;
    private VmReplicationPolicy replicationPolicy;
}
