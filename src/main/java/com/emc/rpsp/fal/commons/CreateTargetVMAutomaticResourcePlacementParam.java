package com.emc.rpsp.fal.commons;

import lombok.*;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("CreateTargetVMAutomaticResourcePlacementParam")
@XmlType(name = "CreateTargetVMAutomaticResourcePlacementParam")
public class CreateTargetVMAutomaticResourcePlacementParam extends CreateTargetVMResourcePlacementParam {

    @XmlElement(required = true)
    private VirtualResourcePoolUUID targetResourcePoolUID;

}
