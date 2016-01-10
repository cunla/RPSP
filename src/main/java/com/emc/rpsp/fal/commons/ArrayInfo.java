package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayInfo")
public class ArrayInfo {

    private String serialNumber;
    @XmlElement(nillable = true)
    private ArrayUID arrayUID;
    private ArrayManagementProviderUID ampUID;
    @XmlElement(nillable = true)
    private ArrayType arrayType;
    @XmlElement(nillable = true)
    private SplitterUID splitterUID;

}
