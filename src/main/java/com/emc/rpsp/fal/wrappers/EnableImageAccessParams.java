package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ImageAccessMode;
import com.emc.rpsp.fal.commons.ImageAccessScenario;
import com.emc.rpsp.fal.commons.Snapshot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EnableImageAccessParams {

    @XmlElement(nillable = true)
    private Snapshot snapshot;
    private ImageAccessMode mode;
    private ImageAccessScenario scenario;
}
