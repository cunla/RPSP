package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("CreateTargetVMManualResourcePlacementParam")
@XmlType(name = "CreateTargetVMManualResourcePlacementParam")
public class CreateTargetVMManualResourcePlacementParam extends CreateTargetVMResourcePlacementParam {

    @XmlElement(required = true)
    private EsxUID targetEsxUID;

    public CreateTargetVMManualResourcePlacementParam() {
    }

    public CreateTargetVMManualResourcePlacementParam(EsxUID targetEsxUID) {
        this.targetEsxUID = targetEsxUID;
    }

    public EsxUID getTargetEsxUID() {
        return targetEsxUID;
    }

    public void setTargetEsxUID(EsxUID targetEsxUID) {
        this.targetEsxUID = targetEsxUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((targetEsxUID == null) ? 0 : targetEsxUID.hashCode());
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
        CreateTargetVMManualResourcePlacementParam other = (CreateTargetVMManualResourcePlacementParam) obj;
        if (targetEsxUID == null) {
            if (other.targetEsxUID != null)
                return false;
        } else if (!targetEsxUID.equals(other.targetEsxUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(
            "CreateTargetVMManualResourcePlacementParam [targetEsxUID=")
            .append(targetEsxUID).append("]");
        return builder.toString();
    }
}
