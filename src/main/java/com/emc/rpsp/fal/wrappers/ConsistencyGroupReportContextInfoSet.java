package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ConsistencyGroupReportContextInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;


@XmlRootElement
@NoArgsConstructor
@Data
public class ConsistencyGroupReportContextInfoSet {
    private HashSet<ConsistencyGroupReportContextInfo> innerSet;

    public ConsistencyGroupReportContextInfoSet(HashSet<ConsistencyGroupReportContextInfo> consistencyGroupReportContextInfoSet) {
        this.innerSet = consistencyGroupReportContextInfoSet;
    }
}
