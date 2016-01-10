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
@XmlType(name = "SetArraySettingsParams")
public class SetArraySettingsParams implements Validateable {

    @XmlElement(nillable = true, required = true)
    private ArrayUID arrayUID;
    @XmlElement(required = true)
    private String name;
    private ConfigurationParams arrayConfiguration;

}
