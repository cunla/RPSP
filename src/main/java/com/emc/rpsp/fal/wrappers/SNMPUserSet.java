package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.SNMPUser;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class SNMPUserSet {
    private Set<SNMPUser> innerSet;

    public SNMPUserSet(Set<SNMPUser> snmpUserSet) {
        this.innerSet = snmpUserSet;
    }
}
