package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.VirtualCenterProtectedVmCountState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;


@XmlRootElement
@NoArgsConstructor
@Data
public class VirtualCenterProtectedVmCountStateSet {
    private HashSet<VirtualCenterProtectedVmCountState> innerSet;

    public VirtualCenterProtectedVmCountStateSet(HashSet<VirtualCenterProtectedVmCountState> virtualCenterProtectedVmCountStateSet) {
        this.innerSet = virtualCenterProtectedVmCountStateSet;
    }
}
