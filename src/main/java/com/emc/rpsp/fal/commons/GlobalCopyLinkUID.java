package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
@XmlType(name = "GlobalCopyLinkUID")
public class GlobalCopyLinkUID implements Validateable {

    private GlobalCopyUID firstCopy;
    private GlobalCopyUID secondCopy;

}
