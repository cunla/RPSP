package com.emc.rpsp.fal.commons;

import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Set;

/**
 * A condition to check an entity status is the wanted status.
 *
 * @author dagano
 */
@XmlRootElement
@XmlType(name = "ConectivityCondition")
@NoArgsConstructor
public class ConectivityCondition<T extends ClusterEntityConnectivityStatus> implements StateCondition<T> {

    private GeneralStatus _wantedStatus;

    public ConectivityCondition(GeneralStatus connectivityStatus) {
        _wantedStatus = connectivityStatus;
    }

    @Override
    public boolean accept(T state) {
        return state.getConnectivityStatus() == _wantedStatus;
    }

    /**
     * @param <T>
     * @param ConnectivityStatus
     * @return a condition that will accepts sets of T's (ClusterEntityConnectivityStatus) which all have the same status - connectivityStatus
     */
    public static <T extends ClusterEntityConnectivityStatus> StateCondition<Set<T>> getConectivityCondition(GeneralStatus connectivityStatus) {
        if (connectivityStatus == null) {
            return VerifyConsistencyGroupStateParam.acceptCondition();
        }
        StateCondition<T> condition = new ConectivityCondition<T>(connectivityStatus);
        return new ConditionAcceptsAll<T>(condition);
    }
}
