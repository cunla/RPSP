package com.emc.rpsp.fal.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourcePoolUID")
public class ResourcePoolUID implements Validateable {

    //This member handles all ResourcePoolUID objects retrieval\creation
//	private static ObjectsGenerator<ResourcePoolUID> resourcePoolUIDgenerator = new ObjectsGenerator<ResourcePoolUID>();

    private long uuid;
    private String storageResourcePoolId;
    @XmlElement(nillable = true, required = true)
    private ArrayUID arrayUid;

    public static ResourcePoolUID generateResourcePoolUID(long uuid, String storageResourcePoolId, ArrayUID arrayUid) {
        return (new ResourcePoolUID(uuid, storageResourcePoolId, arrayUid));
    }

}
