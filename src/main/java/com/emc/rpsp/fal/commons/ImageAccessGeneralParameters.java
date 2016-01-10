package com.emc.rpsp.fal.commons;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ImageAccessQueryParameters.class, ImageAccessLatestSnapshotParameters.class, ImageAccessSpecificSnapshotParameters.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = ImageAccessQueryParameters.class, name = "ImageAccessQueryParameters"),
    @Type(value = ImageAccessLatestSnapshotParameters.class, name = "ImageAccessLatestSnapshotParameters"),
    @Type(value = ImageAccessSpecificSnapshotParameters.class, name = "ImageAccessSpecificSnapshotParameters")})
@XmlType(name = "ImageAccessGeneralParameters")
public abstract
@XmlRootElement
class ImageAccessGeneralParameters implements Validateable {

    @XmlElement(required = true)
    private ImageAccessScenario scenario;
    private ImageAccessTargetVirtualNetworkParam targetNetwork;

    public ImageAccessGeneralParameters(ImageAccessScenario scenario, ImageAccessTargetVirtualNetworkParam targetNetwork) {
        this.scenario = scenario;
        this.targetNetwork = targetNetwork;
    }

}
