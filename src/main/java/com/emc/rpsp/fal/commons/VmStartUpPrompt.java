package com.emc.rpsp.fal.commons;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonTypeName("VmStartUpPrompt")
@XmlType(name = "VmStartUpPrompt")
public class VmStartUpPrompt extends BaseVmStartUpAction {

    @XmlElement(required = true)
    private String message;

    public VmStartUpPrompt(String title, int timeoutSecs, String message) {
        super(title, timeoutSecs);
        this.message = message;
    }

}
