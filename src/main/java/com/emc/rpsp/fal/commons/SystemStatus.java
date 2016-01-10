package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "SystemStatus")
//@LargeObject
public class SystemStatus {

    private HashSet<ProblemDescription> problems;

    public SystemStatus() {
    }

    public SystemStatus(HashSet<ProblemDescription> problems) {
        this.problems = problems;
    }

    public HashSet<ProblemDescription> getProblems() {
        return problems;
    }

    public void setProblems(HashSet<ProblemDescription> problems) {
        this.problems = problems;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((problems == null) ? 0 : problems.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SystemStatus other = (SystemStatus) obj;
        if (problems == null) {
            if (other.problems != null)
                return false;
        } else if (!problems.equals(other.problems))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SystemStatus [problems=").append(problems).append("]");
        return builder.toString();
    }
}
