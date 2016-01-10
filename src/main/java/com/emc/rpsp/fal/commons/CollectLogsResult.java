package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "CollectLogsResult")
public class CollectLogsResult {

    private HashSet<CollectLogsRPAResultValue> rpaResults;
    private HashSet<CollectLogsSplitterResultValue> splitterResults;
    private HashSet<CollectLogsLinkToLogsValue> linksToLogs;
    private CollectLogsResultValue ftpResult;
    private String logsFileName;

    public CollectLogsResult() {
    }

    public CollectLogsResult(HashSet<CollectLogsRPAResultValue> rpaResults, HashSet<CollectLogsSplitterResultValue> splitterResults, HashSet<CollectLogsLinkToLogsValue> linksToLogs,
                             CollectLogsResultValue ftpResult, String logsFileName) {
        this.rpaResults = rpaResults;
        this.splitterResults = splitterResults;
        this.linksToLogs = linksToLogs;
        this.ftpResult = ftpResult;
        this.logsFileName = logsFileName;
    }

    public HashSet<CollectLogsRPAResultValue> getRpaResults() {
        return rpaResults;
    }

    public void setRpaResults(HashSet<CollectLogsRPAResultValue> rpaResults) {
        this.rpaResults = rpaResults;
    }

    public HashSet<CollectLogsSplitterResultValue> getSplitterResults() {
        return splitterResults;
    }

    public void setSplitterResults(HashSet<CollectLogsSplitterResultValue> splitterResults) {
        this.splitterResults = splitterResults;
    }

    public HashSet<CollectLogsLinkToLogsValue> getLinksToLogs() {
        return linksToLogs;
    }

    public void setLinksToLogs(HashSet<CollectLogsLinkToLogsValue> linksToLogs) {
        this.linksToLogs = linksToLogs;
    }

    public CollectLogsResultValue getFtpResult() {
        return ftpResult;
    }

    public void setFtpResult(CollectLogsResultValue ftpResult) {
        this.ftpResult = ftpResult;
    }

    public String getLogsFileName() {
        return logsFileName;
    }

    public void setLogsFileName(String logsFileName) {
        this.logsFileName = logsFileName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ftpResult == null) ? 0 : ftpResult.hashCode());
        result = prime * result + ((linksToLogs == null) ? 0 : linksToLogs.hashCode());
        result = prime * result + ((logsFileName == null) ? 0 : logsFileName.hashCode());
        result = prime * result + ((rpaResults == null) ? 0 : rpaResults.hashCode());
        result = prime * result + ((splitterResults == null) ? 0 : splitterResults.hashCode());
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
        CollectLogsResult other = (CollectLogsResult) obj;
        if (ftpResult == null) {
            if (other.ftpResult != null)
                return false;
        } else if (!ftpResult.equals(other.ftpResult))
            return false;
        if (linksToLogs == null) {
            if (other.linksToLogs != null)
                return false;
        } else if (!linksToLogs.equals(other.linksToLogs))
            return false;
        if (logsFileName == null) {
            if (other.logsFileName != null)
                return false;
        } else if (!logsFileName.equals(other.logsFileName))
            return false;
        if (rpaResults == null) {
            if (other.rpaResults != null)
                return false;
        } else if (!rpaResults.equals(other.rpaResults))
            return false;
        if (splitterResults == null) {
            if (other.splitterResults != null)
                return false;
        } else if (!splitterResults.equals(other.splitterResults))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CollectLogsResult [rpaResults=").append(rpaResults).append(", splitterResults=").append(splitterResults).append(", linksToLogs=").append(linksToLogs)
            .append(", ftpResult=").append(ftpResult).append(", logsFileName=").append(logsFileName).append("]");
        return builder.toString();
    }

}
