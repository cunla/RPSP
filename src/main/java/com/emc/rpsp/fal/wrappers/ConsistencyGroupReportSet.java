package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ConsistencyGroupReport;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;


@XmlRootElement
@NoArgsConstructor
@Data
public class ConsistencyGroupReportSet {
    private HashSet<ConsistencyGroupReport> innerSet;

    public ConsistencyGroupReportSet(HashSet<ConsistencyGroupReport> consistencyGroupReportSet) {
        this.innerSet = consistencyGroupReportSet;
    }
}
