package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
@XmlType(name = "ArrayCapabilities")
public class ArrayCapabilities {
    private HashSet<ArrayCapability> arrayCapabilities;
}
