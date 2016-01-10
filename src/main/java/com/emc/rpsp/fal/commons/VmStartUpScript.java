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
@JsonTypeName("VmStartUpScript")
@XmlType(name = "VmStartUpScript")
public class VmStartUpScript extends BaseVmStartUpAction {

    private int numOfRetries;
    @XmlElement(required = true)
    private String command;

    /**
     * note timeout for script is per retry, unlike prompt
     *
     * @param title
     * @param timeoutSecsPerRetry
     * @param command
     */
    public VmStartUpScript(String title, int timeoutSecsPerRetry, int numOfRetries, String command) {
        super(title, timeoutSecsPerRetry);
        this.numOfRetries = numOfRetries;
        this.command = command;
    }

}
