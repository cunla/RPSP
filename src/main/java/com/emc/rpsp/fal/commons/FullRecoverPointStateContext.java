package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

@JsonTypeName("FullRecoverPointStateContext")
@XmlType(name = "FullRecoverPointStateContext")
public class FullRecoverPointStateContext extends FunctionalAPIContext {

    public FullRecoverPointStateContext() {
    }

    public FullRecoverPointStateContext(long globalContext) {
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
        builder.append("FullRecoverPointStateContext [super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
