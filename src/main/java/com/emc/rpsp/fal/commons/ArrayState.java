package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayState")
////@LargeObject
public class ArrayState {

    @XmlElement(nillable = true)
    private ArrayUID arrayUID;
    private ArrayConnectivityInfo connectivityInfo;
    private ArrayCapabilities capabilities;
    private RpSupportedArrayCapabilities rpSupportedCapabilities;
    @XmlElement(nillable = true)
    private MonitoredParametersStatus arrayLimitations;
    private HashSet<ArrayResourcePoolState> resourcePoolState;
    private String version;
}
