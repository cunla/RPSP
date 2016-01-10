package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlSeeAlso({
    VerifyConsistencyGroupStateParam.class,
    VerifyGroupCopySnapshotsParam.class,
    VerifyRPAStateParam.class,
    VerifySplitterStateParam.class
})
@XmlRootElement
@XmlType(name = "StateCondition")
public interface StateCondition<T> {

    /**
     * @param state
     * @return true iff the {@code state} is accepted by the conditions defined by this object.
     */
    public boolean accept(T state) throws FunctionalAPIActionFailedException, FunctionalAPIInternalError;
}
