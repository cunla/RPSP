package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlType(name = "ResourcePoolUsageStats")
public class ResourcePoolUsageStats {

    private long capacityInBytes;
    private long usedSpaceInBytes;

    public long freeSpaceInBytes() {
        final long free = capacityInBytes - usedSpaceInBytes;
        return (free >= 0) ? free : 0;
    }
}
