package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlType(name = "TextFilter")
public class TextFilter implements Validateable {

    private HashSet<String> texts;
    private boolean allRelevant;

}
