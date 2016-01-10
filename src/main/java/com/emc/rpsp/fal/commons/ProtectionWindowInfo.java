package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlType(name = "ProtectionWindowInfo")
public class ProtectionWindowInfo {

    private long protectionWindowInMicroSeconds;
    private ProtectionWindowStatus status;
}
