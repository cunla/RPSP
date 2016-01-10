package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterFileSystemView")
public class ClusterFileSystemView {

    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private HashSet<FileSystemView> fileSystemViews;

}
