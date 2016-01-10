package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ConsistencyGroupReportStats;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;


@XmlRootElement
@NoArgsConstructor
@Data
public class ConsistencyGroupReportStatsSet {
    private HashSet<ConsistencyGroupReportStats> innerSet;

    public ConsistencyGroupReportStatsSet(HashSet<ConsistencyGroupReportStats> consistencyGroupReportStatsSet) {
        this.innerSet = consistencyGroupReportStatsSet;
    }
}
