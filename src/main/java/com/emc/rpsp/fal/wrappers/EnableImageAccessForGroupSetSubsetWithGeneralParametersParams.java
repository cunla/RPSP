package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ConsistencyGroupSetSubset;
import com.emc.rpsp.fal.commons.ImageAccessGeneralParameters;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class EnableImageAccessForGroupSetSubsetWithGeneralParametersParams {
    private ConsistencyGroupSetSubset groupSetSubset;
    private ImageAccessGeneralParameters generalParams;
}
