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
@XmlType(name = "DatacenterConfiguration")
public class DatacenterConfiguration {

    @XmlElement(nillable = true)
    private DatacenterUID datacenterUID;
    private String name;
    private HashSet<EsxClusterConfiguration> esxClustersConfiguration;
    private HashSet<DatastoreConfiguration> datastoresConfiguration;
    private HashSet<DatastoreClusterConfiguration> datastoreClustersConfiguration;
}
