package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.VmUID;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


@XmlRootElement
@NoArgsConstructor
@Data
public class VmUIDSet {
    private HashSet<VmUID> innerSet;

    public VmUIDSet(HashSet<VmUID> vmUIDSet) {
        this.innerSet = vmUIDSet;
    }

    public VmUIDSet(Collection<VmUID> innerSet) {
        this.innerSet=new HashSet<>(innerSet);
    }
}
