package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.RepositoryVolumeState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class RepositoryVolumeStateSet {
    private Set<RepositoryVolumeState> innerSet;

    public RepositoryVolumeStateSet(Set<RepositoryVolumeState> repositoryVolumeStateSet) {
        this.innerSet = repositoryVolumeStateSet;
    }
}
