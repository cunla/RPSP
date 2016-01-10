package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupCopySettings")
public class ConsistencyGroupCopySettings {

    private ConsistencyGroupCopyUID copyUID;
    private String name;
    private boolean enabled;
    private ConsistencyGroupCopyPolicy policy;
    private ConsistencyGroupCopyRoleInfo roleInfo;
    @XmlElement(nillable = true)
    private ImageAccessInformation imageAccessInformation;
    private ConsistencyGroupCopyJournal journal;
    private boolean hasPhoenixDevices;
    private HashSet<SplitterUID> groupCopySplitters;
}
