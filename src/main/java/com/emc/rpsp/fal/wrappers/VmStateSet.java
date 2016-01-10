package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.VmState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;


@XmlRootElement
@NoArgsConstructor
@Data
public class VmStateSet {
    private HashSet<VmState> innerSet;

    public VmStateSet(HashSet<VmState> vmStateSet) {
        this.innerSet = vmStateSet;
    }
}
