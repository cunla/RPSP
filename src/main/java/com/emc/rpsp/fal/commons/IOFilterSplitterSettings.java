package com.emc.rpsp.fal.commons;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XmlRootElement

@JsonTypeName("IOFilterSplitterSettings")
@XmlType(name = "IOFilterSplitterSettings")
public class IOFilterSplitterSettings extends AggregatedSplitterSettings {

    public IOFilterSplitterSettings(SplitterUID splitterUID, String splitterName,
                                    HashSet<AttachedUserVolumeInfo> attachedUserVolumes,
                                    HashSet<SplitterInfo> singleSplittersInfo, ArrayUID arrayUID) {
        super(splitterUID, splitterName, attachedUserVolumes, singleSplittersInfo,
            SingleSplitterProcessorName.ESX, arrayUID);
    }
}
