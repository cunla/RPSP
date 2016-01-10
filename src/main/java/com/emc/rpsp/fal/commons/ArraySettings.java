package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

/**
 * Array awareness
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArraySettings")
////@LargeObject
public class ArraySettings {

    private String name;
    private String serialNumber;
    @XmlElement(nillable = true)
    private ArrayUID arrayUID;
    private ArrayType type;
    private BaseCredentials credentials;
    private BaseConnectionParams connectionParams;
    private HashSet<ArrayResourcePoolSettings> resourcePools;
}
