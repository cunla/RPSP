package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.StatisticsFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class ExportStatisticsParams {
    private StatisticsFilter filter;
    private String fileName;
}
