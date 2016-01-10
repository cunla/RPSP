package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmStartUpActionsPolicy")
public class VmStartUpActionsPolicy implements Validateable {

    @XmlElement(required = true)
    private ArrayList<BaseVmStartUpAction> prePowerUpActions;
    @XmlElement(required = true)
    private ArrayList<BaseVmStartUpAction> postPowerUpActions;

}
