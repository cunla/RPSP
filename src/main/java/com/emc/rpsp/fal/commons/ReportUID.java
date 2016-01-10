package com.emc.rpsp.fal.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportUID")
public class ReportUID implements Validateable {

    //This member handles all reportUID objects retrieval\creation
//	private static ObjectsGenerator<ReportUID>  reportUIDgenerator = new ObjectsGenerator<ReportUID>();

    private long id; // Unique identifier of the report
    @XmlElement(required = true)
    private ConsistencyGroupUID groupUID;

    public static ReportUID generateReportUID(long id, ConsistencyGroupUID groupUID) {
        return (new ReportUID(id, groupUID));
    }

}
