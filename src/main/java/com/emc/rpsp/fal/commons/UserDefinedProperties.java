package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@XmlType(name = "UserDefinedProperties")
public class UserDefinedProperties implements Validateable {

    private HashSet<Property> properties;

    public UserDefinedProperties() {
    }

    public UserDefinedProperties(HashSet<Property> properties) {
        this.properties = properties;
    }

    public HashSet<Property> getProperties() {
        return properties;
    }

    public void setProperties(HashSet<Property> properties) {
        this.properties = properties;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((properties == null) ? 0 : properties.hashCode());
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
        UserDefinedProperties other = (UserDefinedProperties) obj;
        if (properties == null) {
            if (other.properties != null)
                return false;
        } else if (!properties.equals(other.properties))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserDefinedProperties [properties=").append(properties)
            .append("]");
        return builder.toString();
    }
}
