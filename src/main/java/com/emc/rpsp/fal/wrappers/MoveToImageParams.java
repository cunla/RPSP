package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ImageAccessScenario;
import com.emc.rpsp.fal.commons.SearchImageType;
import com.emc.rpsp.fal.commons.SpecificImageAccessType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class MoveToImageParams {

    private SpecificImageAccessType accessType;
    private SearchImageType imageType;
    private ImageAccessScenario scenario;


}
