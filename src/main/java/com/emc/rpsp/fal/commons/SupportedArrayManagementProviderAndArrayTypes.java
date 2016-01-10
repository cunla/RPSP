package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

/**
 * @author shechn
 *         A set that for each ArrayManagementProviderType will hold a set of its supported ArrayTypes
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlType(name = "SupportedArrayManagementProviderAndArrayTypes")
public class SupportedArrayManagementProviderAndArrayTypes {

    // AMP = Array Management Provider
    private HashSet<ArrayManagementProviderTypesSet> supportedAMPtoArrayTypes;

}
