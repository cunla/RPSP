package com.emc.rpsp.fal.commons;

import lombok.*;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("VplexSplitterCredentials")
@XmlType(name = "VplexSplitterCredentials")
public class VplexSplitterCredentials extends BaseSplitterCredentials {

    private String certificate;

    public VplexSplitterCredentials(String username, boolean passwordConfigured, String ip, String certificate) {
        super(username, passwordConfigured, ip);
        this.certificate = certificate;
    }

}
