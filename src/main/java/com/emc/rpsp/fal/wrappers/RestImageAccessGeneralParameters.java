package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ImageAccessGeneralParameters;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@NoArgsConstructor
@Data
public class RestImageAccessGeneralParameters {
    private ImageAccessGeneralParameters restClass;

    public RestImageAccessGeneralParameters(ImageAccessGeneralParameters restClass) {
        this.restClass = restClass;
    }
}
