package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * A class describing the result of some FAPI operation.
 * It contains the result object itself (when available) and a description of the exceptions occurred will executing the command.
 *
 * @param <T> The type of result of the FAPI operation.
 * @author dagano
 */
// We add all generic transaction results types, otherwise they won't be added to the schema files
@XmlSeeAlso({CollectLogsResult.class, BalanceLoadRecommendation.class, BottlenecksDetectionResult.class})
@XmlRootElement
@XmlType(name = "TransactionResult")
public class TransactionResult<T> {

    private T result;
    // we use the following fields to describes an exception, because an actual Exception object cannot be transfer with web-services.
    private String exceptionMessage;
    private String exceptionType;

    public TransactionResult() {

    }

    public TransactionResult(T result, String exceptionMessage, String exceptionType) {
        super();
        this.result = result;
        this.exceptionMessage = exceptionMessage;
        this.exceptionType = exceptionType;
    }

    /**
     * Ctor to use when operation succeed.
     *
     * @param result
     */
    public TransactionResult(T result) {
        this.result = result;
    }

    /**
     * Ctor to use when operation fails with exception.
     *
     * @param exception
     */
    public TransactionResult(Exception exception) {
        if (exception instanceof BaseFunctionalAPIException) {
            exceptionMessage = exception.getMessage();
            exceptionType = exception.getClass().getName();
        } else {
            exceptionMessage = "Internal error.";
            exceptionType = FunctionalAPIInternalError.class.getName();
        }
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = prime;
        result += this.result.hashCode();
        result *= prime;
        result += this.exceptionMessage.hashCode();
        result *= prime;
        result += this.exceptionType.hashCode();
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TransactionResult<T> other = (TransactionResult<T>) obj;
        if (this.result == null) {
            if (other.result != null)
                return false;
        } else if (!this.result.equals(other.result))
            return false;
        if (this.exceptionType == null) {
            if (other.exceptionType != null)
                return false;
        } else if (!this.exceptionType.equals(other.exceptionType))
            return false;
        if (this.exceptionMessage == null) {
            if (other.exceptionMessage != null)
                return false;
        } else if (!this.exceptionMessage.equals(other.exceptionMessage))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TransactionResult [result=").append(result);
        builder.append("exceptionMessage=").append(exceptionMessage);
        builder.append("exceptionType=").append(exceptionType);
        builder.append("]");
        return builder.toString();
    }
}
