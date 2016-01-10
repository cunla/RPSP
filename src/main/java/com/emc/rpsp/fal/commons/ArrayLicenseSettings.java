package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("ArrayLicenseSettings")
@XmlType(name = "ArrayLicenseSettings")
public class ArrayLicenseSettings extends LicenseSettings {

    private String arraySerial;
    @XmlElement(nillable = true)
    private ArrayType arrayType;

    public ArrayLicenseSettings() {
    }

    public ArrayLicenseSettings(String arraySerial, ArrayType arrayType,
                                LicenseUID licenseUID, int capacity, LicenseCapacityUnit capacityUnit,
                                RecoverPointTimeStamp expirationDate,
                                RecoverPointLicenseType licenseType, Boolean localReplicationOnly) {
        super(licenseUID, capacity, capacityUnit, expirationDate, licenseType, localReplicationOnly);
        this.arraySerial = arraySerial;
        this.arrayType = arrayType;
    }

    public String getArraySerial() {
        return arraySerial;
    }

    public void setArraySerial(String arraySerial) {
        this.arraySerial = arraySerial;
    }

    public ArrayType getArrayType() {
        return arrayType;
    }

    public void setArrayType(ArrayType arrayType) {
        this.arrayType = arrayType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((arraySerial == null) ? 0 : arraySerial.hashCode());
        result = prime * result
            + ((arrayType == null) ? 0 : arrayType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArrayLicenseSettings other = (ArrayLicenseSettings) obj;
        if (arraySerial == null) {
            if (other.arraySerial != null)
                return false;
        } else if (!arraySerial.equals(other.arraySerial))
            return false;
        if (arrayType != other.arrayType)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ArrayLicenseSettings [arraySerial=")
            .append(arraySerial).append(", arrayType=").append(arrayType)
            .append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
