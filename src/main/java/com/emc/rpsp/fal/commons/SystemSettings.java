package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

//import com.emc.fapi.utils.logging.LargeObject;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SystemSettings")
////@LargeObject
public class SystemSettings {

    private HashSet<ClusterSettings> clustersSettings;
    @XmlElement(nillable = true)
    private GlobalSystemConfiguration globalSystemConfiguration;
    private boolean suppressAutoRegistrationWarning;
    private boolean trialAllowed;

}
