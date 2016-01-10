package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.LinkedList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupCopyState")
public class ConsistencyGroupCopyState {

    private ConsistencyGroupCopyUID copyUID;
    private boolean enabled;
    private boolean regulated;
    private boolean suspended;
    private boolean active;
    private boolean removable;
    private int activePrimaryRPA;
    private LinkedList<Integer> activeSecondaryRPAsList;
    private Snapshot accessedImage;
    @XmlElement(nillable = true)
    private StorageAccessState storageAccessState;
    @XmlElement(nillable = true)
    private SplitVariant splitVariant;
    @XmlElement(nillable = true)
    private JournalState journalState;
    private Long maxJournalSizeInBytes;
    @XmlElement(nillable = true)
    private ConsolidationProgress consolidationProgress;
    private Boolean distributedFirstSnapshot;
    private Boolean tspWritesCleared;
    private boolean stateUnknown;
    @XmlElement(nillable = true)
    private AxxanaCopyStatus axxanaCopyStatus;
    private String regulationReason;
    private HashSet<VolumeSize> pendingCreationVolumes;
    private HashSet<VmStartUpActionState> currentStartUpActions;

}
