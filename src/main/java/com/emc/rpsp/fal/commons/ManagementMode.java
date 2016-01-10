package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlType(name = "ManagementMode")
public class ManagementMode implements Validateable {

    private boolean managedByRecoverPoint;
    @XmlElement(nillable = true, required = true)
    private ExternalManagement externalManagement;

}
