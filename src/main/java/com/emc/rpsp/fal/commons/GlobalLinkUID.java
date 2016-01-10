package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GlobalLinkUID")
public class GlobalLinkUID implements Validateable {

    //This member handles all ConsistencyGroupCopyUID objects retrieval\creation
//	private static ObjectsGenerator<GlobalLinkUID>  globalLinkUIDgenerator = new ObjectsGenerator<GlobalLinkUID>();

    @XmlElement(required = true)
    private ClusterUID firstCluster;
    @XmlElement(required = true)
    private ClusterUID secondCluster;

    public static GlobalLinkUID generateGlobalLinkUID(ClusterUID firstCluster, ClusterUID secondCluster) {
        return (new GlobalLinkUID(firstCluster, secondCluster));
    }

}
