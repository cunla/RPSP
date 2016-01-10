package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("VolumeCreationParams")
@XmlType(name = "VolumeCreationParams")
public class VolumeCreationParams extends BaseVolumeParams {
    @XmlElement(nillable = true, required = true)
    private VolumeSize volumeSize;
    @XmlElement(nillable = true)
    private ArrayUID arrayUid;
    private ResourcePoolUID poolUid;
    private ArrayResourcePoolTieringPolicy tieringPolicy;
    private ArrayResourcePoolType resourcePoolType;

}
