package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfigurationParams")
public class ConfigurationParams implements Validateable {

    @XmlElement(required = true)
    private BaseConnectionParams connectionParams;
    @XmlElement(required = true)
    private BaseCredentials credentials;

}
