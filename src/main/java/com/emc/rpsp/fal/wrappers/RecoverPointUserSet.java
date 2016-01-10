package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.RecoverPointUser;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;


@XmlRootElement
@NoArgsConstructor
@Data
public class RecoverPointUserSet {
    private HashSet<RecoverPointUser> innerSet;

    public RecoverPointUserSet(HashSet<RecoverPointUser> recoverPointUserSet) {
        this.innerSet = recoverPointUserSet;
    }
}
