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

@XmlSeeAlso({AggregatedSplitterSettings.class, ArrayBasedSplitterSettings.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = AggregatedSplitterSettings.class, name = "AggregatedSplitterSettings"),
    @Type(value = ArrayBasedSplitterSettings.class, name = "ArrayBasedSplitterSettings")})
@XmlType(name = "SplitterSettings")
////@LargeObject
public class SplitterSettings {

    @XmlElement(nillable = true)
    private SplitterUID splitterUID;
    private String splitterName;
    private HashSet<AttachedUserVolumeInfo> attachedUserVolumes;
    @XmlElement(nillable = true)
    private ArrayUID arrayUID;
}
