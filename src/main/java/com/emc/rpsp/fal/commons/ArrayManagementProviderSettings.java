package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlType(name = "ArrayManagementProviderSettings")
////@LargeObject
public class ArrayManagementProviderSettings {
    private ArrayManagementProviderUID ampUID;
    private String name;
    private ArrayManagementProviderType type;
    private boolean systemGenerated;
    private BaseCredentials credentials;
    private BaseConnectionParams connetionParams;
    private HashSet<ArraySettings> managedArrays;
}
