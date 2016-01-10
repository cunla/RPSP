package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlSeeAlso({FileSystemExtendedInformation.class, FileSystemInformation.class, FileSystemUID.class, FileSystemView.class,
    MountInformation.class, ShareInformation.class, ClusterFileSystemView.class, ClusterFileSystemViewContext.class, VnxServer.class,
    VnxLoginInformation.class, VnxUID.class, ReplicationSetType.class})
@XmlRootElement
@XmlType(name = "VnxClasses")
public class VnxClasses {

}
