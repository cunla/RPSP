package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.RegisterArrayResourcePoolParams;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class RegisterArrayResourcePoolParamsSet {
    private Set<RegisterArrayResourcePoolParams> innerSet;

    public RegisterArrayResourcePoolParamsSet(Set<RegisterArrayResourcePoolParams> registerArrayResourcePoolParamsSet) {
        this.innerSet = registerArrayResourcePoolParamsSet;
    }
}
