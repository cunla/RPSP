package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.SetVolumeParam;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;


@XmlRootElement
@NoArgsConstructor
@Data
public class SetVolumeParamSet {
    private HashSet<SetVolumeParam> innerSet;

    public SetVolumeParamSet(HashSet<SetVolumeParam> setVolumeParamSet) {
        this.innerSet = setVolumeParamSet;
    }
}
