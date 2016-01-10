package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.VCenterServerFilter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@NoArgsConstructor
@Data
public class RestVCenterServerFilter {
    private VCenterServerFilter restClass;

    public RestVCenterServerFilter(VCenterServerFilter restClass) {
        this.restClass = restClass;
    }
}
