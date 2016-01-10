package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.SSHKey;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class SSHKeySet {
    private Set<SSHKey> innerSet;

    public SSHKeySet(Set<SSHKey> sshKeySet) {
        this.innerSet = sshKeySet;
    }
}
