package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.SplitterUID;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;


@XmlRootElement
@NoArgsConstructor
@Data
public class SplitterUIDSet {
    private HashSet<SplitterUID> innerSet;

    public SplitterUIDSet(HashSet<SplitterUID> splitterUIDSet) {
        this.innerSet = splitterUIDSet;
    }
}
