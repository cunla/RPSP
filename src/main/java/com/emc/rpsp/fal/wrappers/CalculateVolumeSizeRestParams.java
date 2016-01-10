package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.CalculateVolumeSizeParams;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class CalculateVolumeSizeRestParams {
    private boolean isDistributedConsistencyGroup;
    private CalculateVolumeSizeParams volumeSizeParams;
}
