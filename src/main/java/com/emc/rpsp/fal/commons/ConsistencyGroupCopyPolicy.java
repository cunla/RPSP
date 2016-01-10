package com.emc.rpsp.fal.commons;

import lombok.*;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

//import com.emc.fapi.version4_3.commons.ValidationUtils.QuantityCategory;

@SuppressWarnings("serial")
@XmlRootElement
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("ConsistencyGroupCopyPolicy")
@XmlType(name = "ConsistencyGroupCopyPolicy")
public class ConsistencyGroupCopyPolicy extends BaseValidatablePolicyTemplateType {

    @XmlElement(nillable = true, required = true)
    private JournalCompressionLevel journalCompressionLevel;
    private Long requiredProtectionWindowInMicroSeconds;
    @XmlElement(nillable = true, required = true)
    private AutomaticSnapshotConsolidationPolicy automaticSnapshotConsolidationPolicy;
    private Quantity rto;
    private double loggedAccessAllocationProportion;
    private long journalSizeLimitInBytes;
    private HostOS hostsOS;
    private boolean allowDistributionOfLargeSnapshots;
    private boolean allowSymmetrixWithOneRPA;
    private RecoverPointTimeStamp fastForwardBound;
    @XmlElement(nillable = true)
    private PhoenixProtectionPolicy phoenixProtectionPolicy;

    @XmlElement(nillable = true)
    private SnapshotsPolicy snapshotsPolicy;

}
