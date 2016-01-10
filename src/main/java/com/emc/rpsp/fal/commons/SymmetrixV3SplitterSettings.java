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

@JsonTypeName("SymmetrixV3SplitterSettings")
@XmlType(name = "SymmetrixV3SplitterSettings")
public class SymmetrixV3SplitterSettings extends AggregatedSplitterSettings {

    public SymmetrixV3SplitterSettings(SplitterUID splitterUID,
                                       String splitterName,
                                       HashSet<AttachedUserVolumeInfo> attachedUserVolumes,
                                       HashSet<SplitterInfo> singleSplittersInfo, ArrayUID arrayUID) {
        super(splitterUID, splitterName, attachedUserVolumes, singleSplittersInfo,
            SingleSplitterProcessorName.DIRECTOR, arrayUID);
    }
}
