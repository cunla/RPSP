package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupSetSubset")
public class ConsistencyGroupSetSubset implements Validateable {
    @XmlElement(required = true)
    protected ConsistencyGroupSetUID groupSetUID;
    protected HashSet<ConsistencyGroupUID> groupsToExclude;

}
