package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.SystemSecurityLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@NoArgsConstructor
@Data
public class RestSystemSecurityLevel {
    private SystemSecurityLevel restEnum;

    public RestSystemSecurityLevel(SystemSecurityLevel restEnum) {
        this.restEnum = restEnum;
    }
}
