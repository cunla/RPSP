package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "BrocadeVirtualTarget")
public class BrocadeVirtualTarget {

    private long targetPWWN;
    private long virtualPWWN;

    public BrocadeVirtualTarget() {
        super();
    }

    public BrocadeVirtualTarget(long targetPWWN, long virtualPWWN) {
        super();
        this.targetPWWN = targetPWWN;
        this.virtualPWWN = virtualPWWN;
    }

    public long getTargetPWWN() {
        return targetPWWN;
    }

    public void setTargetPWWN(long targetPWWN) {
        this.targetPWWN = targetPWWN;
    }

    public long getVirtualPWWN() {
        return virtualPWWN;
    }

    public void setVirtualPWWN(long virtualPWWN) {
        this.virtualPWWN = virtualPWWN;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (targetPWWN ^ (targetPWWN >>> 32));
        result = prime * result + (int) (virtualPWWN ^ (virtualPWWN >>> 32));
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
        BrocadeVirtualTarget other = (BrocadeVirtualTarget) obj;
        if (targetPWWN != other.targetPWWN)
            return false;
        if (virtualPWWN != other.virtualPWWN)
            return false;
        return true;
    }

}
