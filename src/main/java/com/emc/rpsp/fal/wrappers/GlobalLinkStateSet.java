package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.GlobalLinkState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class GlobalLinkStateSet {
    private Set<GlobalLinkState> innerSet;

    public GlobalLinkStateSet(Set<GlobalLinkState> globalLinkStateSet) {
        this.innerSet = globalLinkStateSet;
    }
}
