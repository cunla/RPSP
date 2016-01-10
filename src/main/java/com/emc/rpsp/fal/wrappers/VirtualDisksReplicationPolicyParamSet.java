package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.VirtualDisksReplicationPolicyParam;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;


@XmlRootElement
@NoArgsConstructor
@Data
public class VirtualDisksReplicationPolicyParamSet {
    private HashSet<VirtualDisksReplicationPolicyParam> innerSet;

    public VirtualDisksReplicationPolicyParamSet(HashSet<VirtualDisksReplicationPolicyParam> virtualDisksReplicationPolicyParamSet) {
        this.innerSet = virtualDisksReplicationPolicyParamSet;
    }

}
