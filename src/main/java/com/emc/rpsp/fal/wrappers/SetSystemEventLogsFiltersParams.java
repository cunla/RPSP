package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.SystemEventLogsFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class SetSystemEventLogsFiltersParams {

    private HashSet<SystemEventLogsFilter> filters;

}
