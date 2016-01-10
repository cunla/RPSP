package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ResourcePoolUID;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ResourcePoolUIDSet {
    private Set<ResourcePoolUID> innerSet;

    public ResourcePoolUIDSet(Set<ResourcePoolUID> resourcePoolUIDSet) {
        this.innerSet = resourcePoolUIDSet;
    }
}
