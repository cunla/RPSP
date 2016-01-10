package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlType(name = "VirtualNetworkConfiguration")
public class VirtualNetworkConfiguration {

    private VirtualNetworkUID networkUID;
    private String name;
}
