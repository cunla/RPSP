package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupLinkUID")
public class ConsistencyGroupLinkUID implements Validateable {

    //This member handles all ConsistencyGroupCopyUID objects retrieval\creation
//	private static ObjectsGenerator<ConsistencyGroupLinkUID>  consistencyGroupLinkUIDgenerator = new ObjectsGenerator<ConsistencyGroupLinkUID>();

    @XmlElement(required = true)
    private ConsistencyGroupUID groupUID;
    @XmlElement(required = true)
    private GlobalCopyUID firstCopy;
    @XmlElement(required = true)
    private GlobalCopyUID secondCopy;

    public ConsistencyGroupLinkUID() {
    }

    private ConsistencyGroupLinkUID(ConsistencyGroupUID groupUID, GlobalCopyUID firstCopy, GlobalCopyUID secondCopy) {
        this.groupUID = groupUID;
        this.firstCopy = firstCopy;
        this.secondCopy = secondCopy;
    }

    public static ConsistencyGroupLinkUID generateConsistencyGroupLinkUID(ConsistencyGroupUID groupUID, GlobalCopyUID firstCopy, GlobalCopyUID secondCopy) {
        return (new ConsistencyGroupLinkUID(groupUID, firstCopy, secondCopy));
    }

    public ConsistencyGroupUID getGroupUID() {
        return groupUID;
    }

    public void setGroupUID(ConsistencyGroupUID groupUID) {
        this.groupUID = groupUID;
    }

    public GlobalCopyUID getFirstCopy() {
        return firstCopy;
    }

    public void setFirstCopy(GlobalCopyUID firstCopy) {
        this.firstCopy = firstCopy;
    }

    public GlobalCopyUID getSecondCopy() {
        return secondCopy;
    }

    public void setSecondCopy(GlobalCopyUID secondCopy) {
        this.secondCopy = secondCopy;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((firstCopy == null) ? 0 : firstCopy.hashCode());
        result = prime * result
            + ((groupUID == null) ? 0 : groupUID.hashCode());
        result = prime * result
            + ((secondCopy == null) ? 0 : secondCopy.hashCode());
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
        ConsistencyGroupLinkUID other = (ConsistencyGroupLinkUID) obj;
        if (firstCopy == null) {
            if (other.firstCopy != null)
                return false;
        } else if (!firstCopy.equals(other.firstCopy))
            return false;
        if (groupUID == null) {
            if (other.groupUID != null)
                return false;
        } else if (!groupUID.equals(other.groupUID))
            return false;
        if (secondCopy == null) {
            if (other.secondCopy != null)
                return false;
        } else if (!secondCopy.equals(other.secondCopy))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConsistencyGroupLinkUID [groupUID=").append(groupUID)
            .append(", firstCopy=").append(firstCopy)
            .append(", secondCopy=").append(secondCopy).append("]");
        return builder.toString();
    }

}
