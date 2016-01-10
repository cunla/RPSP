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

@JsonTypeName("Vnx2eSplitterSettings")
@XmlType(name = "Vnx2eSplitterSettings")
public class Vnx2eSplitterSettings extends AggregatedSplitterSettings {

    private boolean autoRegisterRPAsInitiators;
    private ClariionSplitterCredentials credentials;
    private SplitterCredentialsStatus credentialsStatus;

    public Vnx2eSplitterSettings(SplitterUID splitterUID, String splitterName, HashSet<AttachedUserVolumeInfo> attachedUserVolumes,
                                 HashSet<SplitterInfo> singleSplittersInfo, boolean autoRegisterRPAsInitiators, ClariionSplitterCredentials credentials,
                                 SplitterCredentialsStatus credentialsStatus, ArrayUID arrayUID) {
        super(splitterUID, splitterName, attachedUserVolumes, singleSplittersInfo, SingleSplitterProcessorName.SP, arrayUID);
        this.autoRegisterRPAsInitiators = autoRegisterRPAsInitiators;
        this.credentials = credentials;
        this.credentialsStatus = credentialsStatus;
    }
}
