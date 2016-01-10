package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ImageAccessMode;
import com.emc.rpsp.fal.commons.ImageAccessScenario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class EnableLatestImageAccessParams {
    private ImageAccessMode mode;
    private ImageAccessScenario scenario;
}
