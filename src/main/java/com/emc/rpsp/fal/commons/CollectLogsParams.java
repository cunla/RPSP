package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CollectLogsParams")
public class CollectLogsParams implements Validateable {

    @XmlElement(nillable = true)
    private TimeFrame timeFrame;
    @XmlElement(nillable = true)
    private FTPInformation ftpInformation;
    private boolean includeCoreFiles;
    private boolean ignoreConnectivityErrors;
    private LinkedList<RpaUID> rpas;
    private LinkedList<CollectLogsSplitterParam> splitters;

    // TODO: Remove splittersWithoutCredentials, clariionCredentials and vplexCredentials fields
    // in ferdinand as part of the change for the aggregated splitter API.
    private LinkedList<SplitterUID> splittersWithoutCredentials;
    private LinkedList<ClariionSplitter> clariionCredentials;
    private LinkedList<VplexSplitter> vplexCredentials;
    private boolean uniteLogsToOneTar;

}
