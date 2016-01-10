package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)

@XmlSeeAlso({SymmetrixSplitterState.class, AggregatedSplitterState.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = SymmetrixSplitterState.class, name = "SymmetrixSplitterState"),
    @Type(value = AggregatedSplitterState.class, name = "AggregatedSplitterState")})
@XmlType(name = "SplitterState")
////@LargeObject
public class SplitterState {
    @XmlElement(nillable = true)
    private SplitterUID splitterUID;
    @XmlElement(nillable = true)
    private SplitterStatus splitterStatus;
    private int numberOfAttachedRPAClusters;
    private HashSet<RPAConnectivityStatus> rpasConnectivityStatus;
    private HashSet<AttachedUserVolumeAccessState> volumesAccessState;
    private HashSet<SplitterOSAndVersionInfo> osAndVersionInfo;
    private HashSet<Path> rpasPaths;
    private HashSet<Capability> splitterCapabilities;

}
