package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ArrayType;
import com.emc.rpsp.fal.commons.ConfigurationParams;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CheckArrayConnectivityParams {

    @XmlElement(nillable = true)
    private ArrayType arrayType;
    private ConfigurationParams arrayConfiguration;
}
