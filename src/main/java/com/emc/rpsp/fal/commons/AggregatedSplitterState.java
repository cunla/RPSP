package com.emc.rpsp.fal.commons;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor

@JsonTypeName("AggregatedSplitterState")
@XmlType(name = "AggregatedSplitterState")
public class AggregatedSplitterState extends SplitterState {
    private HashSet<SplitterState> singleSplittersState;

    public AggregatedSplitterState(SplitterUID splitterUID,
                                   SplitterStatus splitterStatus,
                                   int numberOfAttachedRPAClusters,
                                   HashSet<RPAConnectivityStatus> rpasConnectivityStatus,
                                   HashSet<AttachedUserVolumeAccessState> volumesAccessState,
                                   HashSet<SplitterOSAndVersionInfo> osAndVersionInfo,
                                   HashSet<Path> rpasPaths,
                                   HashSet<Capability> splitterCapabilities,
                                   HashSet<SplitterState> singleSplittersState) {
        super(splitterUID, splitterStatus, numberOfAttachedRPAClusters, rpasConnectivityStatus, volumesAccessState, osAndVersionInfo,
            rpasPaths, splitterCapabilities);
        this.singleSplittersState = singleSplittersState;
    }
}
