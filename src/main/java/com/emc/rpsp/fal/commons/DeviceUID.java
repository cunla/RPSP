package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//import com.emc.fapi.utils.cache.*;
//import com.emc.fapi.utils.logging.LargeObject;


@SuppressWarnings("serial")
@XmlRootElement
@XmlType(name = "DeviceUID")
////@LargeObject // this is for commands that returns a big set of DeviceUIDs
public class DeviceUID implements Validateable {

    //This member handles all DeviceUID objects retrieval\creation
//	private static ObjectsGenerator<DeviceUID>  deviceUIDgenerator = new ObjectsGenerator<DeviceUID>();

    public static DeviceUID generateDeviceUID(long id) {
        return (new DeviceUID(id));
    }

    private long id;

    //TODO annotate - this CTOR should NOT be used! (due to UIDs cache)
    public DeviceUID() {
    }

    private DeviceUID(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DeviceUID other = (DeviceUID) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DeviceUID [id=").append(id).append("]");
        return builder.toString();
    }
}
