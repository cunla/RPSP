package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ConsistencyGroupSetSubset;
import com.emc.rpsp.fal.commons.ImageAccessMode;
import com.emc.rpsp.fal.commons.ImageAccessScenario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class EnableLatestImageAccessForGroupSetSubsetParams {
    private ConsistencyGroupSetSubset groupSetSubset;
    private ImageAccessMode mode;
    private ImageAccessScenario scenario;
}
