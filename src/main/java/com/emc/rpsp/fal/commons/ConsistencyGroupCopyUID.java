package com.emc.rpsp.fal.commons;

import lombok.Data;

import javax.xml.bind.annotation.*;


@Data
@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupCopyUID")
public class ConsistencyGroupCopyUID implements Validateable {

    //This member handles all ConsistencyGroupCopyUID objects retrieval\creation
//	private static ObjectsGenerator<ConsistencyGroupCopyUID>  consistencyGroupCopyUIDgenerator = new ObjectsGenerator<ConsistencyGroupCopyUID>();

    public static ConsistencyGroupCopyUID generateConsistencyGroupCopyUID(ConsistencyGroupUID groupUID, GlobalCopyUID globalCopyUID) {
        return (new ConsistencyGroupCopyUID(groupUID, globalCopyUID));
    }

    @XmlElement(required = true)
    private ConsistencyGroupUID groupUID;
    @XmlElement(nillable = true, required = true)
    private GlobalCopyUID globalCopyUID;

    //TODO annotate - this CTOR should NOT be used! (due to UIDs cache)
    public ConsistencyGroupCopyUID() {
    }

    public ConsistencyGroupCopyUID(ConsistencyGroupUID groupUID, GlobalCopyUID globalCopyUID) {
        this.groupUID = groupUID;
        this.globalCopyUID = globalCopyUID;
    }

}
