package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
@XmlType(name = "MonitoredParametersStatus")
public class MonitoredParametersStatus {

    private HashSet<MonitoredParameter> parameters;
}
