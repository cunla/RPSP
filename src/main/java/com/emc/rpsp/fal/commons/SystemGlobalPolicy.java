package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlType(name = "SystemGlobalPolicy")
public class SystemGlobalPolicy implements Validateable {

    private int numberOfCommunicationStreams;
    private boolean advancedActionRegulationEnabled;
    private boolean shouldCollectLongTermStatistics;

}
