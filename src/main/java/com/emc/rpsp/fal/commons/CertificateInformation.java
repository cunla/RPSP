package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlType(name = "CertificateInformation")
public class CertificateInformation {

    private String pemCertificate;
    private String issuerDN;
    private String subjectDN;
    private String sha1;
    private String md5; // belongs to sha1
    private String validNotBefore;
    private String validNotAfter;
}
