package com.emc.rpsp.fal.commons;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("VplexCredentials")
@XmlType(name = "VplexCredentials")
public class VplexCredentials extends BaseCredentials {

    @XmlElement(required = true)
    private VplexCredentialsType credentialsType;
    @XmlElement(required = true)
    private String certificate;

    public VplexCredentials(String username, byte[] password, VplexCredentialsType credentialsType,
                            String certificate) {
        super(username, password);
        this.credentialsType = credentialsType;
        this.certificate = certificate;
    }

}
