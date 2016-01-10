package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlType(name = "VirtualCenterProtectedVmCountState")
public class VirtualCenterProtectedVmCountState {

    private VirtualCenterUID vcUID;
    private long protectedVmCount;

}
