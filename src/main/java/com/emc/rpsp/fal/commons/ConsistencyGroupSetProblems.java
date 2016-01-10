package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlType(name = "ConsistencyGroupSetProblems")
public class ConsistencyGroupSetProblems {

    private HashSet<ConsistencyGroupUID> illegalGroups;
    private String errorMessage; // Error message should contain information about problems of all cgs in groupsToExclude

}
