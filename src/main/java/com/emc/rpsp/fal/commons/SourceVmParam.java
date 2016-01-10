package com.emc.rpsp.fal.commons;

//import com.emc.fapi.utils.cache.ObjectsGenerator;

import lombok.*;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("SourceVmParam")
@XmlType(name = "SourceVmParam")
public class SourceVmParam extends ExistingVMParam {

    @XmlElement(nillable = true, required = true)
    private ClusterUID clusterUID;

    //This member handles all SourceVmUID objects retrieval\creation
//    private static ObjectsGenerator<SourceVmParam> sourceVmUIDgenerator = new ObjectsGenerator<SourceVmParam>();

    public SourceVmParam(ClusterUID clusterUID, VmUID vmUID) {
        super(vmUID);
        this.clusterUID = clusterUID;
    }

    public static SourceVmParam generateSourceVmParam(ClusterUID clusterUID, VmUID vmUID) {
        return (new SourceVmParam(clusterUID, vmUID));
    }

}
