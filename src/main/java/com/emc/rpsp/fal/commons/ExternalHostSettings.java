package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalHostSettings")
public class ExternalHostSettings implements Validateable {

    @XmlElement(required = true)
    private ExternalHostUID hostUID;
    @XmlElement(required = true)
    private ExternalHostParams hostParams;

}
