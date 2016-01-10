package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.VCenterServerFilters;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class VCenterServerFiltersSet {
    private Set<VCenterServerFilters> innerSet;

    public VCenterServerFiltersSet(Set<VCenterServerFilters> vcServerFiltersSet) {
        this.innerSet = vcServerFiltersSet;
    }
}
