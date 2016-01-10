package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.SystemEventLogsFilter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class SystemEventLogsFilterSet {
    private Set<SystemEventLogsFilter> innerSet;

    public SystemEventLogsFilterSet(Set<SystemEventLogsFilter> systemEventLogsFilterSet) {
        this.innerSet = systemEventLogsFilterSet;
    }
}
