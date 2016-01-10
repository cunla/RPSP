package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LDAPBinding")
public class LDAPBinding implements Validateable {

    @XmlElement(required = true)
    private String bindDistinguishedName;
    private byte[] password;
    private boolean passwordConfigured;

}
