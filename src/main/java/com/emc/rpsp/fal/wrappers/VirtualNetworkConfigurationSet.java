package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.VirtualNetworkConfiguration;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class VirtualNetworkConfigurationSet {
    private Set<VirtualNetworkConfiguration> innerSet;

    public VirtualNetworkConfigurationSet(Set<VirtualNetworkConfiguration> virtualNetworkConfigurationSet) {
        this.innerSet = virtualNetworkConfigurationSet;
    }
}
