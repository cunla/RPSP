package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlType
@XmlRootElement(name = "BaseRecoveryActivity")
@XmlSeeAlso({ConsistencyGroupCopyRecoveryActivity.class, ConsistencyGroupSetRecoveryActivity.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({@Type(value = ConsistencyGroupCopyRecoveryActivity.class, name = "ConsistencyGroupCopyRecoveryActivity"),
    @Type(value = ConsistencyGroupSetRecoveryActivity.class, name = "ConsistencyGroupSetRecoveryActivity")})
public abstract class BaseRecoveryActivity {

    private ImageAccessScenario activity;
    private String clusterName;

}
