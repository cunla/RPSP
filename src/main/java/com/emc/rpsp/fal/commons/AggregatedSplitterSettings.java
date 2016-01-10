package com.emc.rpsp.fal.commons;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor

@JsonTypeName("AggregatedSplitterSettings")
@XmlSeeAlso({Vnx2eSplitterSettings.class, VplexSplitterSettings.class, EsxSplitterSettings.class, IOFilterSplitterSettings.class, SymmetrixV3SplitterSettings.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = Vnx2eSplitterSettings.class, name = "Vnx2eSplitterSettings"),
    @Type(value = VplexSplitterSettings.class, name = "VplexSplitterSettings"),
    @Type(value = EsxSplitterSettings.class, name = "EsxSplitterSettings"),
    @Type(value = IOFilterSplitterSettings.class, name = "IOFilterSplitterSettings"),
    @Type(value = SymmetrixV3SplitterSettings.class, name = "SymmetrixV3SplitterSettings")})
@XmlType(name = "AggregatedSplitterSettings")
public class AggregatedSplitterSettings extends SplitterSettings {

    private HashSet<SplitterInfo> singleSplittersInfo;
    private SingleSplitterProcessorName singleSplitterName;

    public AggregatedSplitterSettings(SplitterUID splitterUID, String splitterName, HashSet<AttachedUserVolumeInfo> attachedUserVolumes,
                                      HashSet<SplitterInfo> singleSplittersInfo, SingleSplitterProcessorName singleSplitterName,
                                      ArrayUID arrayUID) {
        super(splitterUID, splitterName, attachedUserVolumes, arrayUID);
        this.singleSplittersInfo = singleSplittersInfo;
        this.singleSplitterName = singleSplitterName;
    }
}
