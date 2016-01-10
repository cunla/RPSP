package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.HostConnectivityStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@NoArgsConstructor
@Data
public class RestHostConnectivityStatus {
    private HostConnectivityStatus restEnum;

    public RestHostConnectivityStatus(HostConnectivityStatus restEnum) {
        this.restEnum = restEnum;
    }
}
