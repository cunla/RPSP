package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.VMReplicationSetParam;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "vmReplicationSetParamSet",
    propOrder = {"innerSet"}
)
public class VmReplicationSetParamSet {
    @XmlElement(
        nillable = true
    )
    protected List<VMReplicationSetParam> innerSet;

    public VmReplicationSetParamSet() {
    }

    public VmReplicationSetParamSet(List<VMReplicationSetParam> innerSet) {
        this.innerSet = innerSet;
    }

    public List<VMReplicationSetParam> getInnerSet() {
        if(this.innerSet == null) {
            this.innerSet = new ArrayList();
        }

        return this.innerSet;
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof VmReplicationSetParamSet)) {
            return false;
        } else {
            VmReplicationSetParamSet otherObj = (VmReplicationSetParamSet)obj;
            return this.innerSet != null?this.innerSet.equals(otherObj.innerSet):this.innerSet == otherObj.innerSet;
        }
    }

    public int hashCode() {
        return this.innerSet != null?this.innerSet.hashCode():0;
    }

    public String toString() {
        return "VmReplicationSetParamSet [innerSet=" + this.innerSet + "]";
    }
}
