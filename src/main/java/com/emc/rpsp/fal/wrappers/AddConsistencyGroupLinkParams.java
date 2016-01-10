package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ConsistencyGroupLinkPolicy;
import com.emc.rpsp.fal.commons.GlobalCopyUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class AddConsistencyGroupLinkParams {

    private GlobalCopyUID firstCopy;
    private GlobalCopyUID secondCopy;
    private ConsistencyGroupLinkPolicy policy;

}
