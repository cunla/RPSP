package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterSupportedArrayManagementProviderAndArrayTypes")
public class ClusterSupportedArrayManagementProviderAndArrayTypes {

    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private SupportedArrayManagementProviderAndArrayTypes supportedAmpsAndArraysTypes;
}
