package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupLinkSettings")
public class ConsistencyGroupLinkSettings implements Validateable {

    @XmlElement(required = true)
    private ConsistencyGroupLinkUID groupLinkUID;
    @XmlElement(required = true)
    private ConsistencyGroupLinkPolicy linkPolicy;
    private boolean transferEnabled;
    private boolean localLink;

}
