package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatastoreConfiguration")
public class DatastoreConfiguration {

    @XmlElement(nillable = true)
    private DatastoreUID datastoreUID;
    private String name;
    private long capacity;
    private long freeSpace;
    private HashSet<EsxUID> relevantEsxsUuids;
}
