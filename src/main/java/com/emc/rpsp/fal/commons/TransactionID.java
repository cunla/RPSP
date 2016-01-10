package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * When performing an asynchronous (typically long) operation FAPI provides a
 * unique object of this type, for further queries about the operation.
 *
 * @param <T> The type of result the operation returns.
 * @author dagano
 */
@SuppressWarnings("serial")
@XmlRootElement
@XmlType(name = "TransactionID")
public class TransactionID<T> implements Validateable {

    private long id;

    public TransactionID() {

    }

    public TransactionID(long id) {
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
        @SuppressWarnings("unchecked")
        TransactionID<T> other = (TransactionID<T>) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TransactionID [id=" + id + "]";
    }


}
