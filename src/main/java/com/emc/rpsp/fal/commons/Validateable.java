package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@JsonTypeName("Validateable")
@XmlRootElement
@XmlType(name = "Validateable")
public interface Validateable extends Serializable {

//	public void validate() throws FunctionalAPIActionFailedException;
}
