package com.emc.rpsp.fal.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//import com.emc.fapi.utils.cache.*;

@SuppressWarnings("serial")
@Data
//this CTOR should NOT be used! (due to UIDs cache)
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlType(name = "ClusterUID")
public class ClusterUID implements Validateable {

    private long id;

    //This member handles all ClusterUID objects retrieval\creation
//	private static ObjectsGenerator<ClusterUID>  clusterUIDgenerator = new ObjectsGenerator<ClusterUID>();

    public static ClusterUID generateClusterUID(long id) {
        return (new ClusterUID(id));
    }

}
