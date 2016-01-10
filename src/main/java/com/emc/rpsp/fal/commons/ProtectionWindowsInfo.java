package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "ProtectionWindowsInfo")
public class ProtectionWindowsInfo {

    private ProtectionWindowInfo currentProtectionWindow;
    private ProtectionWindowInfo predictedProtectionWindow;

    public ProtectionWindowsInfo() {
    }

    public ProtectionWindowsInfo(ProtectionWindowInfo currentProtectionWindow, ProtectionWindowInfo predictedProtectionWindow) {
        this.currentProtectionWindow = currentProtectionWindow;
        this.predictedProtectionWindow = predictedProtectionWindow;
    }

    public ProtectionWindowInfo getCurrentProtectionWindow() {
        return currentProtectionWindow;
    }

    public void setCurrentProtectionWindow(
        ProtectionWindowInfo currentProtectionWindow) {
        this.currentProtectionWindow = currentProtectionWindow;
    }

    public ProtectionWindowInfo getPredictedProtectionWindow() {
        return predictedProtectionWindow;
    }

    public void setPredictedProtectionWindow(
        ProtectionWindowInfo predictedProtectionWindow) {
        this.predictedProtectionWindow = predictedProtectionWindow;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((currentProtectionWindow == null) ? 0
            : currentProtectionWindow.hashCode());
        result = prime
            * result
            + ((predictedProtectionWindow == null) ? 0
            : predictedProtectionWindow.hashCode());
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
        ProtectionWindowsInfo other = (ProtectionWindowsInfo) obj;
        if (currentProtectionWindow == null) {
            if (other.currentProtectionWindow != null)
                return false;
        } else if (!currentProtectionWindow
            .equals(other.currentProtectionWindow))
            return false;
        if (predictedProtectionWindow == null) {
            if (other.predictedProtectionWindow != null)
                return false;
        } else if (!predictedProtectionWindow
            .equals(other.predictedProtectionWindow))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ProtectionWindowsInfo [currentProtectionWindow=")
            .append(currentProtectionWindow).append(
            ", predictedProtectionWindow=").append(
            predictedProtectionWindow).append("]");
        return builder.toString();
    }
}
