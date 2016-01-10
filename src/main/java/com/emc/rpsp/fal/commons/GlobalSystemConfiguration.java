package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlType(name = "GlobalSystemConfiguration")
public class GlobalSystemConfiguration {

    private HashSet<ClusterConfiguration> clustersConfigurations;
    private HashSet<MTUInformation> mtusInformation;
    private String accountId;
}
