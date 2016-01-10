package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ArrayConfigRequirement;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ArrayConfigRequirementSet {
    private Set<ArrayConfigRequirement> innerSet;

    public ArrayConfigRequirementSet(Set<ArrayConfigRequirement> arrayConfigRequirement) {
        this.innerSet = arrayConfigRequirement;
    }
}
