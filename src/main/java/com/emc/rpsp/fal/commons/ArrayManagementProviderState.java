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
@XmlType(name = "ArrayManagementProviderState")
////@LargeObject
public class ArrayManagementProviderState {

    private ArrayManagementProviderUID ampUID;
    private ArrayConnectivityInfo connectivityInfo;
    private HashSet<ArrayState> arraysState;
}
