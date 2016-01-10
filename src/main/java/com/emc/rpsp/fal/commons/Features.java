package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlType(name = "Features")
public class Features {

    private HashSet<String> features;
}
