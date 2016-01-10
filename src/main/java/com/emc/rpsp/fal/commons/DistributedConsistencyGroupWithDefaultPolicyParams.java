package com.emc.rpsp.fal.commons;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.LinkedList;


@Data
@XmlRootElement
@XmlType(name = "DistributedConsistencyGroupWithDefaultPolicyParams")
public class DistributedConsistencyGroupWithDefaultPolicyParams {
    private String groupName;
    private RpaUID primaryRPA;
    private LinkedList<RpaUID> secondaryRPAsList;
}
