package com.emc.rpsp.fal.commons;

import lombok.*;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@XmlRootElement
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Data

@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("CollectLogsSplitterParamWithCredentials")
@XmlType(name = "CollectLogsSplitterParamWithCredentials")
public class CollectLogsSplitterParamWithCredentials extends CollectLogsSplitterParam {

    @XmlElement(required = true)
    private BaseSplitterCredentials credentials;
    private byte[] password;

}
