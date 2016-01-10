package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LDAPSettings")
public class LDAPSettings implements Validateable {

    private boolean enabled;
    @XmlElement(required = true)
    private LDAPProtocol protocol;
    private LDAPServer primaryServer;
    private LDAPServer secondaryServer;
    @XmlElement(required = true)
    private String baseDistinguishedName;
    @XmlElement(required = true)
    private String distinguishedNameSearch;
    @XmlElement(required = true)
    private LDAPBinding binding;
    @XmlElement(required = true)
    private LDAPAdvancedSettings advancedSettings;

}
