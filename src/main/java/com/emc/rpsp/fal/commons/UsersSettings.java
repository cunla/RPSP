package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;


@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlType(name = "UsersSettings")
public class UsersSettings implements Validateable {

    @XmlElement(required = true)
    private HashSet<UserRole> usersRoles;
    @XmlElement(required = true)
    private HashSet<RecoverPointUser> users;
    @XmlElement(nillable = true, required = true)
    private LDAPSettings ldapSettings;


}
