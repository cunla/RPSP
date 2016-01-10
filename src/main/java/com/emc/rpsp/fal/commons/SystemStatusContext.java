package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

@JsonTypeName("SystemStatusContext")
@XmlType(name = "SystemStatusContext")
public class SystemStatusContext extends FunctionalAPIContext {

    public SystemStatusContext() {
    }

    public SystemStatusContext(long globalContext) {
        super(globalContext);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SystemStatusContext [super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
