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

@JsonTypeName("VplexSplitterSettings")
@XmlType(name = "VplexSplitterSettings")
public class VplexSplitterSettings extends AggregatedSplitterSettings {

    private SplitterCredentialsStatus credentialsStatus;
    private VplexSplitterCredentials credentials;
    private boolean autoRegisterRPAsInitiators;

    public VplexSplitterSettings(SplitterUID splitterUID, String splitterName, HashSet<AttachedUserVolumeInfo> attachedUserVolumes,
                                 boolean autoRegisterRPAsInitiators, SplitterCredentialsStatus credentialsStatus,
                                 VplexSplitterCredentials credentials, HashSet<SplitterInfo> singleSplittersInfo, ArrayUID arrayUID) {
        super(splitterUID, splitterName, attachedUserVolumes, singleSplittersInfo, SingleSplitterProcessorName.DIRECTOR, arrayUID);
        this.autoRegisterRPAsInitiators = autoRegisterRPAsInitiators;
        this.credentialsStatus = credentialsStatus;
        this.credentials = credentials;
    }

}
