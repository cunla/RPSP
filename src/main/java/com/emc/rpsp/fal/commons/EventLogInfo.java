package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "EventLogInfo")
public class EventLogInfo {

    private EventLogTopic topic;
    private EventLogLevel level;
    private String summary;
    private String seSummary;
    private EventLogScope scope;
    private String moreDetails;
    private String userAction;

    public EventLogInfo() {
    }

    public EventLogInfo(EventLogTopic topic, EventLogLevel level,
                        String summary, String seSummary, EventLogScope scope,
                        String moreDetails, String userAction) {
        this.topic = topic;
        this.level = level;
        this.summary = summary;
        this.seSummary = seSummary;
        this.scope = scope;
        this.moreDetails = moreDetails;
        this.userAction = userAction;
    }

    /**
     * @return the topic
     */
    public EventLogTopic getTopic() {
        return topic;
    }

    /**
     * @param topic the topic to set
     */
    public void setTopic(EventLogTopic topic) {
        this.topic = topic;
    }

    /**
     * @return the level
     */
    public EventLogLevel getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(EventLogLevel level) {
        this.level = level;
    }

    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return the seSummary
     */
    public String getSeSummary() {
        return seSummary;
    }

    /**
     * @param seSummary the seSummary to set
     */
    public void setSeSummary(String seSummary) {
        this.seSummary = seSummary;
    }

    /**
     * @return the scope
     */
    public EventLogScope getScope() {
        return scope;
    }

    /**
     * @param scope the scope to set
     */
    public void setScope(EventLogScope scope) {
        this.scope = scope;
    }

    /**
     * @return the moreDetails
     */
    public String getMoreDetails() {
        return moreDetails;
    }

    /**
     * @param moreDetails the moreDetails to set
     */
    public void setMoreDetails(String moreDetails) {
        this.moreDetails = moreDetails;
    }

    /**
     * @return the userAction
     */
    public String getUserAction() {
        return userAction;
    }

    /**
     * @param userAction the userAction to set
     */
    public void setUserAction(String userAction) {
        this.userAction = userAction;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((level == null) ? 0 : level.hashCode());
        result = prime * result
            + ((moreDetails == null) ? 0 : moreDetails.hashCode());
        result = prime * result + ((scope == null) ? 0 : scope.hashCode());
        result = prime * result
            + ((seSummary == null) ? 0 : seSummary.hashCode());
        result = prime * result + ((summary == null) ? 0 : summary.hashCode());
        result = prime * result + ((topic == null) ? 0 : topic.hashCode());
        result = prime * result
            + ((userAction == null) ? 0 : userAction.hashCode());
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
        EventLogInfo other = (EventLogInfo) obj;
        if (level == null) {
            if (other.level != null)
                return false;
        } else if (!level.equals(other.level))
            return false;
        if (moreDetails == null) {
            if (other.moreDetails != null)
                return false;
        } else if (!moreDetails.equals(other.moreDetails))
            return false;
        if (scope == null) {
            if (other.scope != null)
                return false;
        } else if (!scope.equals(other.scope))
            return false;
        if (seSummary == null) {
            if (other.seSummary != null)
                return false;
        } else if (!seSummary.equals(other.seSummary))
            return false;
        if (summary == null) {
            if (other.summary != null)
                return false;
        } else if (!summary.equals(other.summary))
            return false;
        if (topic == null) {
            if (other.topic != null)
                return false;
        } else if (!topic.equals(other.topic))
            return false;
        if (userAction == null) {
            if (other.userAction != null)
                return false;
        } else if (!userAction.equals(other.userAction))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EventLogInfo [level=").append(level).append(
            ", moreDetails=").append(moreDetails).append(", scope=")
            .append(scope).append(", seSummary=").append(seSummary).append(
            ", summary=").append(summary).append(", topic=")
            .append(topic).append(", userAction=").append(userAction)
            .append("]");
        return builder.toString();
    }
}
