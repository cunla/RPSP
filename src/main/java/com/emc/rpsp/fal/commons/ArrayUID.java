package com.emc.rpsp.fal.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

//import com.emc.fapi.utils.cache.ObjectsGenerator;

@SuppressWarnings("serial")
@Data
// this CTOR should NOT be used! (due to UIDs cache)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayUID")
public class ArrayUID implements Validateable {

    private long id;
    @XmlElement(nillable = true, required = true)
    private ClusterUID clusterUID;

    //This member handles all ArrayUID objects retrieval\creation
//	private static ObjectsGenerator<ArrayUID> arrayUIDgenerator = new ObjectsGenerator<ArrayUID>();

    public static ArrayUID generateArrayUID(long id, ClusterUID clusterUID) {
        return (new ArrayUID(id, clusterUID));
    }

}
