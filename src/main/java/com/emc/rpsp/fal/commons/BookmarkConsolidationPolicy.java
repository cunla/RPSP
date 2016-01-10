package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum BookmarkConsolidationPolicy {
    ALWAYS_CONSOLIDATE("AlwaysConsolidate"),
    SURVIVE_DAILY("SurviveDaily"),
    SURVIVE_WEEKLY("SurviveWeekly"),
    SURVIVE_MONTHLY("SurviveMonthly"),
    NEVER_CONSOLIDATE("NeverConsolidate"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
