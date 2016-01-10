package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlType(name = "ConsistencyGroupLinkStatistics")
public class ConsistencyGroupLinkStatistics {

    private ConsistencyGroupLinkUID linkUID;
    private ConsistencyGroupLinkInitStatistics initStatistics;
    private ConsistencyGroupLinkPipeStatistics pipeStatistics;
}
