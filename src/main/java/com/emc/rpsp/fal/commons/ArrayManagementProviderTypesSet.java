package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

/**
 * @author shechn
 *         For each ArrayManagementProviderType hold set of its supported ArrayTypes
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlType(name = "ArrayManagementProviderTypesSet")
public class ArrayManagementProviderTypesSet {

    private ArrayManagementProviderType ampType;
    private HashSet<ArrayType> supportedArrayTypes;

}
