package com.emc.rpsp.fal.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportStepUID")
public class ReportStepUID implements Validateable {

    //This member handles all reportStepUID objects retrieval\creation
//	private static ObjectsGenerator<ReportStepUID>  reportStepUIDgenerator = new ObjectsGenerator<ReportStepUID>();

    private short id; // Unique identifier of the reportStep

    public static ReportStepUID generateReportStepUID(short id) {
        return (new ReportStepUID(id));
    }

}
