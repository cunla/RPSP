package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ClusterMaintenanceMode;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@NoArgsConstructor
@Data
public class RestClusterMaintenanceMode {
    private ClusterMaintenanceMode restEnum;

    public RestClusterMaintenanceMode(ClusterMaintenanceMode restEnum) {
        this.restEnum = restEnum;
    }
}
