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
@JsonTypeName("VolumeSelectionParam")
@XmlType(name = "VolumeSelectionParam")
public class VolumeSelectionParam extends BaseVolumeParams {

    @XmlElement(nillable = true, required = true)
    private DeviceUID deviceUID;

}
