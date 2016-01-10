package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlType(name = "MonitoredParameterWaterMarks")
public class MonitoredParameterWaterMarks {

    private long lowWaterMark;
    private long highWaterMark;
    private long limit;
}
