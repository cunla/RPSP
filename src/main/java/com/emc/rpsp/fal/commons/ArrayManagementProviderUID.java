package com.emc.rpsp.fal.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@Data
// this CTOR should NOT be used! (due to UIDs cache)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayManagementProviderUID")
public class ArrayManagementProviderUID implements Validateable {

    private long id;
    @XmlElement(nillable = true)
    private ClusterUID clusterUID;

//	//This member handles all ArrayManagementProviderUID objects retrieval\creation
//	private static ArrayManagementProviderUID ampUIDgenerator = new ArrayManagementProviderUID();

    public static ArrayManagementProviderUID generateArrayManagementProviderUID(long id, ClusterUID clusterUID) {
        return new ArrayManagementProviderUID(id, clusterUID);
    }

}
