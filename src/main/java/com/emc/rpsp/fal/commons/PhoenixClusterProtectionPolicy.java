package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
@XmlRootElement
@XmlType(name = "PhoenixClusterProtectionPolicy")
public class PhoenixClusterProtectionPolicy implements Validateable {

    private boolean domino;
    private boolean regulate;
}
