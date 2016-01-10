package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ConsistencyGroupCopyProtectionWindowsInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ConsistencyGroupCopyProtectionWindowsInfoSet {
    private Set<ConsistencyGroupCopyProtectionWindowsInfo> innerSet;

    public ConsistencyGroupCopyProtectionWindowsInfoSet(
        Set<ConsistencyGroupCopyProtectionWindowsInfo> cgCopyProtectionWindowsInfoSet) {
        this.innerSet = cgCopyProtectionWindowsInfoSet;
    }
}
