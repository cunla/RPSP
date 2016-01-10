package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlType(name = "VmReplicationSetUID")
public class VmReplicationSetUID implements Validateable {
    //This member handles all ArrayManagementProviderUID objects retrieval\creation
//    private static VmReplicationSetUID uidsGenerator = new VmReplicationSetUID();
    private long uid;

    public static VmReplicationSetUID generateVmReplicationSetUID(long uid) {
        return new VmReplicationSetUID(uid);
    }

}
