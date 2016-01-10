package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlType(name = "VmUID")
public class VmUID implements Validateable {


    public static VmUID generateVmUID(String uuid, VirtualCenterUID virtualCenterUID) {
        return new VmUID(uuid, virtualCenterUID);
    }

    @XmlElement(required = true)
    private String uuid;
    @XmlElement(nillable = true, required = true)
    private VirtualCenterUID virtualCenterUID;

}
