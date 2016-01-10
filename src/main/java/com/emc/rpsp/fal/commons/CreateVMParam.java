package com.emc.rpsp.fal.commons;

import lombok.*;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@XmlSeeAlso({SourceVmParam.class})

@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("CreateVMParam")
@XmlType(name = "CreateVMParam")
public class CreateVMParam extends VMParam {

    @XmlElement(required = true)
    private VirtualCenterUID targetVirtualCenterUID;
    @XmlElement(required = true)
    private CreateTargetVMResourcePlacementParam targetResourcePlacementParam;
    @XmlElement(required = true)
    private DatastoreUID targetDatastoreUID;

}
