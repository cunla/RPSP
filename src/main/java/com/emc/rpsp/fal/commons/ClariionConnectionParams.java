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

@JsonTypeName("ClariionConnectionParams")
@XmlType(name = "ClariionConnectionParams")
public class ClariionConnectionParams extends BaseConnectionParams {

    private IPInformation spbIP;

    public ClariionConnectionParams(IPInformation mgmtIP, IPInformation spbIP) {
        super(mgmtIP);
        this.spbIP = spbIP;
    }
}
