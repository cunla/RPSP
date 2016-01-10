package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.GlobalCopyUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class RemovePassiveConsistencyGroupLinkParams {

    private GlobalCopyUID firstCopy;
    private GlobalCopyUID secondCopy;

}
