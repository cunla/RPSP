package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.VmPowerUpSequenceParam;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class VmPowerUpSequenceParamSet {
    private Set<VmPowerUpSequenceParam> innerSet;

    public VmPowerUpSequenceParamSet(Set<VmPowerUpSequenceParam> vmPowerUpSequenceParamSet) {
        this.innerSet = vmPowerUpSequenceParamSet;
    }
}
