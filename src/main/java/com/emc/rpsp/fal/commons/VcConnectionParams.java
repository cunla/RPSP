package com.emc.rpsp.fal.commons;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XmlRootElement

@JsonTypeName("VcConnectionParams")
@XmlType(name = "VcConnectionParams")
public class VcConnectionParams extends BaseConnectionParams {

    private int port;

    public VcConnectionParams(IPInformation mgmtIP, int port) {
        super(mgmtIP);
        this.port = port;
    }
}
