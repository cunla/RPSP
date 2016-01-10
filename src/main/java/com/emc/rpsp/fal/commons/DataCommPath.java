package com.emc.rpsp.fal.commons;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("DataCommPath")
@XmlType(name = "DataCommPath")
public class DataCommPath extends Path {
    @XmlElement(nillable = true)
    private SplitterUID splitterUid;

    public DataCommPath(RpaUID rpaUID, SplitterUID splitterUid) {
        super(rpaUID);
        this.splitterUid = splitterUid;
    }
}
