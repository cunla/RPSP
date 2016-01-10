package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.VolumeInformation;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class VolumeInformationSet {
    private Set<VolumeInformation> innerSet;

    public VolumeInformationSet(Set<VolumeInformation> volumeInformationSet) {
        this.innerSet = volumeInformationSet;
    }
}
