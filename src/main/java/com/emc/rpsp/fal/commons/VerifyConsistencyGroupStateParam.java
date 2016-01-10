package com.emc.rpsp.fal.commons;


import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Conditions to be verified on a consistency group and it's copies and links.
 * Every field left with the null value will simply be ignored, and not checked for.
 * It is possible to request verifying against the settings, in which new VerifyConsistencyGroupStateParam object will be created,
 * to present the settings for this group (the settingCondition field).
 *
 * @author dagano
 */
@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerifyConsistencyGroupStateParam")
public class VerifyConsistencyGroupStateParam implements Validateable, StateCondition<ConsistencyGroupState> {

    @XmlElement(required = true)
    private ConsistencyGroupUID group; // used to get the group settings.
    private boolean againstSettings; // if true the rest of the fields will be ignored, and the verifying will be done against the settings.
    private Boolean groupEnabled = null;
    private ConsistencyGroupCopyUID sourceCopy = null;
    private Boolean distributed = null;

    private HashSet<ConsistencyGroupLinkUID> links = null;
    private VerifyConsistencyGroupLinkStateParam defaultLinkCondition = null; // used to verify links that are not in linksConditions.
    // if null, those links will be ignored.
    private HashSet<VerifyConsistencyGroupLinkStateParam> linksConditions = null;

    private HashSet<ConsistencyGroupCopyUID> copies = null; // if null, all copies are examined.
    private VerifyConsistencyGroupCopyStateParam defaultCopyCondition = null; // used to verify copies that are not in copiesConditions.
    // if null, those copies will be ignored.
    private HashSet<VerifyConsistencyGroupCopyStateParam> copiesConditions = null;

    // this field is not part of the 'common fields', it's for internal use only (shouldn't have any getter nor setter)
    private VerifyConsistencyGroupStateParam settingsCondition = null; // a condition-like representation of the settings
    @XmlElement(required = true)
    private String username; // this field should be used only if comparing the state to the settings

    public VerifyConsistencyGroupStateParam() {
    }

    public VerifyConsistencyGroupStateParam(
        ConsistencyGroupUID group,
        boolean againstSettings,
        Boolean groupEnabled,
        ConsistencyGroupCopyUID sourceCopy,
        Boolean distributed,
        HashSet<ConsistencyGroupLinkUID> links,
        VerifyConsistencyGroupLinkStateParam defaultLinkCondition,
        HashSet<VerifyConsistencyGroupLinkStateParam> linksConditions,
        HashSet<ConsistencyGroupCopyUID> copies,
        VerifyConsistencyGroupCopyStateParam defaultCopyCondition,
        HashSet<VerifyConsistencyGroupCopyStateParam> copiesConditions) {
        this.group = group;
        this.againstSettings = againstSettings;
        this.groupEnabled = groupEnabled;
        this.sourceCopy = sourceCopy;
        this.distributed = distributed;
        this.links = links;
        this.defaultLinkCondition = defaultLinkCondition;
        this.linksConditions = linksConditions;
        this.copies = copies;
        this.defaultCopyCondition = defaultCopyCondition;
        this.copiesConditions = copiesConditions;
    }

    /**
     * @param <T>
     * @return a state condition that which accepts any state.
     */
    public static <T> StateCondition<T> acceptCondition() {
        return new StateCondition<T>() {

            @Override
            public boolean accept(T state) {
                return true;
            }
        };
    }


//    private VerifyConsistencyGroupStateParam buildSettingsCondition() throws FunctionalAPIActionFailedException, FunctionalAPIInternalError {
//        ConsistencyGroupSettings groupSettings = new FunctionalAPIImpl().getGroupSettings(group); // getting the setting of the group
//        if (groupSettings == null) {
//            throw new FunctionalAPIInternalError(FAPIMessages.UNEXPECTED_RETURN_VALUE_FROM_MGMT_SERVER);
//        }
//
//        HashSet<ConsistencyGroupCopyUID> settingsCopies = copies; // the copies we want to verify are the copies the user provided
//        HashSet<ConsistencyGroupLinkUID> settingsLinks = links; // the links we want to verify are the links the user provided
//        Boolean settingsGroupEnabled = groupSettings.isEnabled();
//        ConsistencyGroupCopyUID settingsSourceCopy = groupSettings.getLatestSourceCopyUID();
//        Boolean settingsDistributed = groupSettings.getPolicy().isDistributedGroup();
//
//
//        HashSet<VerifyConsistencyGroupCopyStateParam> settingsCopiesConditions = createSettingsCopiesConditions(groupSettings);
//
//        HashSet<VerifyConsistencyGroupLinkStateParam> settingsLinksConditions = createSettingsLinksConditions(groupSettings);
//
//        // againstSettings must be false!!! (otherwise it's a loop)
//        return new VerifyConsistencyGroupStateParam(group, false, settingsGroupEnabled, settingsSourceCopy, settingsDistributed,
//            settingsLinks, null, settingsLinksConditions, settingsCopies, defaultCopyCondition, settingsCopiesConditions);
//    }

    @Override
    public boolean accept(ConsistencyGroupState state) throws FunctionalAPIActionFailedException, FunctionalAPIInternalError {
        // check if we need to make the verify against the settings only
        if (againstSettings) {
            if (settingsCondition == null) {
//                settingsCondition = buildSettingsCondition();
            }
            return settingsCondition.accept(state);
        }

        if (groupEnabled != null) {
            if (!groupEnabled.equals(state.isEnabled()))
                return false;
        }
        if (sourceCopy != null) {
            if (!state.getSourceCopiesUIDs().contains(sourceCopy))
                return false;
        }
        if (distributed != null) {
            if (!distributed.equals(state.isRunningAsDistributedGroup()))
                return false;
        }
        Set<ConsistencyGroupCopyState> relevantCopies = extractRelevantCopies(state);
        if (!getCopiesCondition().accept(relevantCopies))
            return false;

        Set<ConsistencyGroupLinkState> relevantLinks = extractRelevantLinks(state);
        if (!getLinksCondition().accept(relevantLinks))
            return false;

        // found nothing wrong - assuming OK.
        return true;
    }

//    private HashSet<VerifyConsistencyGroupLinkStateParam> createSettingsLinksConditions(ConsistencyGroupSettings groupSettings) {
//        HashSet<ConsistencyGroupLinkSettings> groupLinksSettings = groupSettings.getActiveLinksSettings();
//        HashSet<VerifyConsistencyGroupLinkStateParam> settingsLinksCondition = new HashSet<VerifyConsistencyGroupLinkStateParam>();
//        if (groupLinksSettings == null) {
//            return settingsLinksCondition;
//        }
//
//        for (ConsistencyGroupLinkSettings linkSettings : groupLinksSettings) {
//            settingsLinksCondition.add(buildLinkCondition(groupSettings, linkSettings));
//        }
//
//        return settingsLinksCondition;
//    }

//    private HashSet<VerifyConsistencyGroupCopyStateParam> createSettingsCopiesConditions(ConsistencyGroupSettings groupSettings) {
//        HashSet<ConsistencyGroupCopySettings> groupCopiesSettings = groupSettings.getGroupCopiesSettings();
//        HashSet<VerifyConsistencyGroupCopyStateParam> settingsCopiesCondition = new HashSet<VerifyConsistencyGroupCopyStateParam>();
//        if (groupCopiesSettings == null) {
//            return settingsCopiesCondition;
//        }
//
//        for (ConsistencyGroupCopySettings copySettings : groupCopiesSettings) {
//            settingsCopiesCondition.add(buildCopyCondition(groupSettings, copySettings));
//        }
//
//        return settingsCopiesCondition;
//    }

    private StateCondition<Set<ConsistencyGroupCopyState>> getCopiesCondition() {
        if ((copiesConditions == null) && (defaultCopyCondition == null))
            return acceptCondition();
        StateCondition<Set<ConsistencyGroupCopyState>> condition = new StateCondition<Set<ConsistencyGroupCopyState>>() {

            @Override
            public boolean accept(Set<ConsistencyGroupCopyState> state) throws FunctionalAPIActionFailedException, FunctionalAPIInternalError {
                for (ConsistencyGroupCopyState copyState : state) {
                    ConsistencyGroupCopyUID copyUID = copyState.getCopyUID();
                    VerifyConsistencyGroupCopyStateParam wantedState = getCopyCondition(copyUID);
                    wantedState = (wantedState == null) ? defaultCopyCondition : wantedState; // use default if not in copiesConditions.
                    if (wantedState == null) { // if there is no default we ignore this copy
                        break;
                    }
                    if (!wantedState.accept(copyState)) {
                        return false;
                    }
                }
                return true;
            }

        };
        return condition;
    }

    private VerifyConsistencyGroupCopyStateParam getCopyCondition(ConsistencyGroupCopyUID copyUID) {
        if (copiesConditions == null) {
            return null;
        }

        for (VerifyConsistencyGroupCopyStateParam copyCondition : copiesConditions) {
            if (copyCondition.getCopyUID().equals(copyUID)) {
                return copyCondition;
            }
        }

        return null;
    }

    private StateCondition<Set<ConsistencyGroupLinkState>> getLinksCondition() {
        if ((linksConditions == null) && (defaultLinkCondition == null))
            return acceptCondition();
        StateCondition<Set<ConsistencyGroupLinkState>> condition = new StateCondition<Set<ConsistencyGroupLinkState>>() {

            @Override
            public boolean accept(Set<ConsistencyGroupLinkState> state) throws FunctionalAPIActionFailedException, FunctionalAPIInternalError {
                for (ConsistencyGroupLinkState linkState : state) {
                    ConsistencyGroupLinkUID linkUID = linkState.getGroupLinkUID();
                    VerifyConsistencyGroupLinkStateParam wantedState = getLinkCondition(linkUID);
                    wantedState = (wantedState == null) ? defaultLinkCondition : wantedState; // use default if not in linksConditions.
                    if (wantedState == null) { // if there is no default we ignore this link
                        break;
                    }
                    if (!wantedState.accept(linkState)) {
                        return false;
                    }
                }
                return true;
            }


        };
        return condition;
    }

    private VerifyConsistencyGroupLinkStateParam getLinkCondition(ConsistencyGroupLinkUID linkUID) {
        if (linksConditions == null) {
            return null;
        }

        for (VerifyConsistencyGroupLinkStateParam linkCondition : linksConditions) {
            if (linkCondition.getLinkUID().equals(linkUID)) {
                return linkCondition;
            }
        }

        return null;
    }

    private Set<ConsistencyGroupLinkState> extractRelevantLinks(ConsistencyGroupState state) {
        Set<ConsistencyGroupLinkState> relevantLinks = new HashSet<ConsistencyGroupLinkState>();
        if (links != null) {
            for (ConsistencyGroupLinkState link : state.getLinksState()) {
                if (links.contains(link.getGroupLinkUID())) {
                    relevantLinks.add(link);
                }
            }
        } else {
            relevantLinks.addAll(state.getLinksState());
        }

        return relevantLinks;

    }

    private Set<ConsistencyGroupCopyState> extractRelevantCopies(ConsistencyGroupState state) {
        Set<ConsistencyGroupCopyState> relevantCopies = new HashSet<ConsistencyGroupCopyState>();
        if (copies != null) {
            for (ConsistencyGroupCopyState copy : state.getGroupCopiesState()) {
                if (copies.contains(copy.getCopyUID())) {
                    relevantCopies.add(copy);
                }
            }
        } else {
            relevantCopies.addAll(state.getGroupCopiesState());
        }

        return relevantCopies;
    }

    public ConsistencyGroupUID getGroup() {
        return group;
    }

    public void setGroup(ConsistencyGroupUID group) {
        this.group = group;
    }

    public boolean getAgainstSettings() {
        return againstSettings;
    }

    public void setAgainstSettings(boolean againstSettings) {
        this.againstSettings = againstSettings;
    }

    public Boolean getGroupEnabled() {
        return groupEnabled;
    }

    public void setGroupEnabled(Boolean groupEnabled) {
        this.groupEnabled = groupEnabled;
    }

    public ConsistencyGroupCopyUID getSourceCopy() {
        return sourceCopy;
    }

    public void setSourceCopy(ConsistencyGroupCopyUID sourceCopy) {
        this.sourceCopy = sourceCopy;
    }

    public Boolean getDistributed() {
        return distributed;
    }

    public void setDistributed(Boolean distributed) {
        this.distributed = distributed;
    }

    public HashSet<ConsistencyGroupLinkUID> getLinks() {
        return links;
    }

    public void setLinks(HashSet<ConsistencyGroupLinkUID> links) {
        this.links = links;
    }

    public VerifyConsistencyGroupLinkStateParam getDefaultLinkCondition() {
        return defaultLinkCondition;
    }

    public void setDefaultLinkCondition(
        VerifyConsistencyGroupLinkStateParam defaultLinkCondition) {
        this.defaultLinkCondition = defaultLinkCondition;
    }

    public HashSet<VerifyConsistencyGroupLinkStateParam> getLinksConditions() {
        return linksConditions;
    }

    public void setLinksConditions(
        HashSet<VerifyConsistencyGroupLinkStateParam> linksConditions) {
        this.linksConditions = linksConditions;
    }

    public HashSet<ConsistencyGroupCopyUID> getCopies() {
        return copies;
    }

    public void setCopies(HashSet<ConsistencyGroupCopyUID> copies) {
        this.copies = copies;
    }

    public VerifyConsistencyGroupCopyStateParam getDefaultCopyCondition() {
        return defaultCopyCondition;
    }

    public void setDefaultCopyCondition(
        VerifyConsistencyGroupCopyStateParam defaultCopyCondition) {
        this.defaultCopyCondition = defaultCopyCondition;
    }

    public HashSet<VerifyConsistencyGroupCopyStateParam> getCopiesConditions() {
        return copiesConditions;
    }

    public void setCopiesConditions(
        HashSet<VerifyConsistencyGroupCopyStateParam> copiesConditions) {
        this.copiesConditions = copiesConditions;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (againstSettings ? 1231 : 1237);
        result = prime * result + ((copies == null) ? 0 : copies.hashCode());
        result = prime
            * result
            + ((copiesConditions == null) ? 0 : copiesConditions.hashCode());
        result = prime
            * result
            + ((defaultCopyCondition == null) ? 0 : defaultCopyCondition
            .hashCode());
        result = prime
            * result
            + ((defaultLinkCondition == null) ? 0 : defaultLinkCondition
            .hashCode());
        result = prime * result
            + ((distributed == null) ? 0 : distributed.hashCode());
        result = prime * result + ((group == null) ? 0 : group.hashCode());
        result = prime * result
            + ((groupEnabled == null) ? 0 : groupEnabled.hashCode());
        result = prime * result + ((links == null) ? 0 : links.hashCode());
        result = prime * result
            + ((linksConditions == null) ? 0 : linksConditions.hashCode());
        result = prime
            * result
            + ((settingsCondition == null) ? 0 : settingsCondition
            .hashCode());
        result = prime * result
            + ((sourceCopy == null) ? 0 : sourceCopy.hashCode());
        result = prime * result
            + ((username == null) ? 0 : username.hashCode());
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
        VerifyConsistencyGroupStateParam other = (VerifyConsistencyGroupStateParam) obj;
        if (againstSettings != other.againstSettings)
            return false;
        if (copies == null) {
            if (other.copies != null)
                return false;
        } else if (!copies.equals(other.copies))
            return false;
        if (copiesConditions == null) {
            if (other.copiesConditions != null)
                return false;
        } else if (!copiesConditions.equals(other.copiesConditions))
            return false;
        if (defaultCopyCondition == null) {
            if (other.defaultCopyCondition != null)
                return false;
        } else if (!defaultCopyCondition.equals(other.defaultCopyCondition))
            return false;
        if (defaultLinkCondition == null) {
            if (other.defaultLinkCondition != null)
                return false;
        } else if (!defaultLinkCondition.equals(other.defaultLinkCondition))
            return false;
        if (distributed == null) {
            if (other.distributed != null)
                return false;
        } else if (!distributed.equals(other.distributed))
            return false;
        if (group == null) {
            if (other.group != null)
                return false;
        } else if (!group.equals(other.group))
            return false;
        if (groupEnabled == null) {
            if (other.groupEnabled != null)
                return false;
        } else if (!groupEnabled.equals(other.groupEnabled))
            return false;
        if (links == null) {
            if (other.links != null)
                return false;
        } else if (!links.equals(other.links))
            return false;
        if (linksConditions == null) {
            if (other.linksConditions != null)
                return false;
        } else if (!linksConditions.equals(other.linksConditions))
            return false;
        if (settingsCondition == null) {
            if (other.settingsCondition != null)
                return false;
        } else if (!settingsCondition.equals(other.settingsCondition))
            return false;
        if (sourceCopy == null) {
            if (other.sourceCopy != null)
                return false;
        } else if (!sourceCopy.equals(other.sourceCopy))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VerifyConsistencyGroupStateParam [againstSettings=")
            .append(againstSettings).append(", copies=").append(copies)
            .append(", copiesConditions=").append(copiesConditions).append(
            ", defaultCopyCondition=").append(defaultCopyCondition)
            .append(", defaultLinkCondition=").append(defaultLinkCondition)
            .append(", distributed=").append(distributed)
            .append(", group=").append(group).append(", groupEnabled=")
            .append(groupEnabled).append(", links=").append(links).append(
            ", linksConditions=").append(linksConditions).append(
            ", settingsCondition=").append(settingsCondition)
            .append(", sourceCopy=").append(sourceCopy).append(
            ", username=").append(username).append("]");
        return builder.toString();
    }
}
