package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@SuppressWarnings("serial")

@JsonTypeName("ImageAccessLatestSnapshotParameters")
@XmlRootElement
@XmlType(name = "ImageAccessLatestSnapshotParameters")
public class ImageAccessLatestSnapshotParameters extends ImageAccessGeneralParameters {

}
