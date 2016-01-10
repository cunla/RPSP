package com.emc.rpsp.fal.commons;

import lombok.*;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("ClariionSplitterCredentials")
@XmlType(name = "ClariionSplitterCredentials")
public class ClariionSplitterCredentials extends BaseSplitterCredentials {

    @XmlElement(required = true)
    private ClariionSplitterCredentialsType credentialsType;
    private String SPBip;
    @XmlElement(nillable = true, required = true)
    private AuthenticationType authenticationType;

    public ClariionSplitterCredentials(String username, AuthenticationType authenticationType, boolean passwordConfigured,
                                       String SPAip, String SPBip, ClariionSplitterCredentialsType credentialsType) {
        super(username, passwordConfigured, SPAip);
        this.credentialsType = credentialsType;
        this.SPBip = SPBip;
        this.authenticationType = authenticationType;

    }
}
