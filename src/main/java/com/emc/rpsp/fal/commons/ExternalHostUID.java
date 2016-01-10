package com.emc.rpsp.fal.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

//import com.emc.fapi.utils.cache.ObjectsGenerator;

@SuppressWarnings("serial")
@Data
//this CTOR should NOT be used! (due to UIDs cache)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalHostUID")
public class ExternalHostUID implements Validateable {

    private long id;
    @XmlElement(nillable = true, required = true)
    private ClusterUID clusterUID;

    //This member handles all ExternalHostUID objects retrieval\creation
//	private static ObjectsGenerator<ExternalHostUID> externalHostUIDgenerator = new ObjectsGenerator<>();

    public static ExternalHostUID generateExternalHostUID(long id, ClusterUID clusterUID) {
        return (new ExternalHostUID(id, clusterUID));
    }

}
