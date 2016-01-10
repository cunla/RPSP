package com.emc.rpsp.fal.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

//import com.emc.fapi.utils.cache.*;

@SuppressWarnings("serial")
@Data
//TODO annotate - this CTOR should NOT be used! (due to UIDs cache)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SplitterUID")
public class SplitterUID implements Validateable {

    //This member handles all SplitterUID objects retrieval\creation
//	private static SplitterUID>  splitterUIDgenerator = new ObjectsGenerator<SplitterUID>();

    public static SplitterUID generateSplitterUID(ClusterUID clusterUID, long id, SplitterType splitterType) {
        return new SplitterUID(clusterUID, id, splitterType);
    }

    @XmlElement(nillable = true, required = true)
    private ClusterUID clusterUID;
    private long id;
    @XmlElement(nillable = true, required = true)
    private SplitterType splitterType;

}
