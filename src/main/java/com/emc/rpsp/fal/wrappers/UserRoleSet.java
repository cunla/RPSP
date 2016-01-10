package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class UserRoleSet {
    private Set<UserRole> innerSet;

    public UserRoleSet(Set<UserRole> userRoleSet) {
        this.innerSet = userRoleSet;
    }
}
