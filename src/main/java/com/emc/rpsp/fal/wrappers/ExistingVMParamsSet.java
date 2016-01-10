package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ExistingVMParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;


@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExistingVMParamsSet {

    private HashSet<ExistingVMParam> innerSet;
}
