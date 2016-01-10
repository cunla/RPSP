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

@JsonTypeName("SymmetrixSplitterState")
@XmlType(name = "SymmetrixSplitterState")
public class SymmetrixSplitterState extends SplitterState {
    private HashSet<DeviceUID> srdfVolumes;

    public SymmetrixSplitterState(SplitterUID splitterUID,
                                  SplitterStatus splitterStatus, int numberOfAttachedRPAClusters,
                                  HashSet<RPAConnectivityStatus> rpasConnectivityStatus,
                                  HashSet<AttachedUserVolumeAccessState> volumesAccessState,
                                  HashSet<SplitterOSAndVersionInfo> osAndVersionInfo,
                                  HashSet<Path> rpasPaths,
                                  HashSet<Capability> splitterCapabilities,
                                  HashSet<DeviceUID> srdfVolumes) {
        super(splitterUID, splitterStatus, numberOfAttachedRPAClusters, rpasConnectivityStatus, volumesAccessState, osAndVersionInfo,
            rpasPaths, splitterCapabilities);
        this.srdfVolumes = srdfVolumes;
    }
}
