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

@JsonTypeName("VcCredentials")
@XmlType(name = "VcCredentials")
public class VcCredentials extends BaseCredentials {

    @XmlElement(required = true)
    private String certificate;

    public VcCredentials(String username, byte[] password, String certificate) {
        super(username, password);
        this.certificate = certificate;
    }

}
