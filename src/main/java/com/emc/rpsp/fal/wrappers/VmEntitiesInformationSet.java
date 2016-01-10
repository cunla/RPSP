package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.VMEntitiesInformation;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;


@XmlRootElement
@NoArgsConstructor
@Data
public class VmEntitiesInformationSet {
    private HashSet<VMEntitiesInformation> innerSet;

    public VmEntitiesInformationSet(HashSet<VMEntitiesInformation> vmEntitiesInformationSet) {
        this.innerSet = vmEntitiesInformationSet;
    }
}
