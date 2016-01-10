package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.RPAStatistics;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class RPAStatisticsSet {
    private Set<RPAStatistics> innerSet;

    public RPAStatisticsSet(Set<RPAStatistics> rpaStatisticsSet) {
        this.innerSet = rpaStatisticsSet;
    }
}
