package com.emc.rpsp.fal.commons;

//import com.emc.fapi.utils.cache.ObjectsGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@Data
//this CTOR should NOT be used! (due to UIDs cache)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "VmStartUpActionUID")
public class VmStartUpActionUID implements Validateable {

    private long id;
    @XmlElement(nillable = true, required = true)
    private VmUID vmUID;

//	//This member handles all VmStartUpActionUID objects retrieval\creation
//	private static ObjectsGenerator<VmStartUpActionUID> uidGenerator = new ObjectsGenerator<>();

    public static VmStartUpActionUID generateVmStartUpActionUID(long id, VmUID vmUID) {
        return new VmStartUpActionUID(id, vmUID);
    }

}
