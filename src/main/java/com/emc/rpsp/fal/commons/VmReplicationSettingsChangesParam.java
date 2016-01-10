package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmReplicationSettingsChangesParam")
public class VmReplicationSettingsChangesParam implements Validateable {

    @XmlElement(required = true)
    private ConsistencyGroupCopyUID copyUID;
    @XmlElement(nillable = true, required = true)
    private VMParam vmParam;

}
