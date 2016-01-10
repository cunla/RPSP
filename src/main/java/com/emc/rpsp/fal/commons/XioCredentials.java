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

@JsonTypeName("XioCredentials")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XioCredentials")
public class XioCredentials extends BaseCredentials {

    @XmlElement(required = true)
    private String certificate;

    public XioCredentials(String username, byte[] password, String certificate) {
        super(username, password);
        this.certificate = certificate;
    }

}
