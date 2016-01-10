package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClariionSplitter")
public class ClariionSplitter implements Validateable {

    @XmlElement(required = true)
    private SplitterUID splitter;
    private ClariionSplitterCredentials creds;
    @XmlElement(required = true)
    private byte[] password;

}
