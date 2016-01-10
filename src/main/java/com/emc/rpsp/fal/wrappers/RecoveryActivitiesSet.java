package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.BaseRecoveryActivity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class RecoveryActivitiesSet {

    private Set<BaseRecoveryActivity> innerSet;

    public RecoveryActivitiesSet(Set<BaseRecoveryActivity> recoveryActivitiesSet) {
        this.innerSet = recoveryActivitiesSet;
    }
}
