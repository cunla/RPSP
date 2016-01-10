package com.emc.rpsp.fal.commons;

import lombok.*;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("VnxSplitterCredentials")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@XmlType(name = "VnxSplitterCredentials")
public class VnxSplitterCredentials extends BaseSplitterCredentials {
    //class needs refactor due to changes in BaseArrayBasedSplitterCredentials object model.
    @XmlElement(required = true)
    private String certificate;
    private int SPAport;
    private int SPBport;

}
