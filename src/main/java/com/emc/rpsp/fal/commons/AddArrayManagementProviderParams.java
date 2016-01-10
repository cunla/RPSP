package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlType(name = "AddArrayManagementProviderParams")
public class AddArrayManagementProviderParams implements Validateable {

    private String name;
    private ArrayManagementProviderUID ampUID;
    private ArrayManagementProviderType ampType;
    private ConfigurationParams ampConfiguration;
    private boolean force;

}
