package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlType(name = "VmStartUpActionState")
public class VmStartUpActionState {

    private VmStartUpActionUID vmActionUID;
    private BaseVmStartUpAction vmStartUpStep;
}

