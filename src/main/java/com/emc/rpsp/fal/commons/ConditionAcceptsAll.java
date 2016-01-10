package com.emc.rpsp.fal.commons;

import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Set;

/**
 * A condition that takes a set of T's and accepts iff all objects in the set are accepted by the condition provided in the condition's Ctor.
 *
 * @param <T>
 * @author dagano
 */
@XmlRootElement
@XmlType(name = "ConditionAcceptsAll")
@NoArgsConstructor
public class ConditionAcceptsAll<T> implements StateCondition<Set<T>> {

    private StateCondition<T> _condition;

    public ConditionAcceptsAll(StateCondition<T> condition) {
        _condition = condition;
    }

    @Override
    public boolean accept(Set<T> state) throws FunctionalAPIActionFailedException, FunctionalAPIInternalError {
        for (T t : state) {
            if (!_condition.accept(t)) {
                return false;
            }
        }
        return true;
    }
}
