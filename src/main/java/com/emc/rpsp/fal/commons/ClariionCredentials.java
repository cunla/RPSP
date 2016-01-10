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

@JsonTypeName("ClariionCredentials")
@XmlType(name = "ClariionCredentials")
public class ClariionCredentials extends BaseCredentials {

    @XmlElement(required = true)
    private ClariionCredentialsType credentialsType;
    @XmlElement(nillable = true, required = true)
    private AuthenticationType authenticationType;
    private String certificate;

    public ClariionCredentials(String username, byte[] password, ClariionCredentialsType credentialsType,
                               AuthenticationType authenticationType, String certificate) {
        super(username, password);
        this.credentialsType = credentialsType;
        this.authenticationType = authenticationType;
        this.certificate = certificate;
    }


}
