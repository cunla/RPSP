package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum BottlenecksDetectionMode {
    SYSTEM_OVERVIEW_AND_BOTTLENECK_ANALYSIS("SystemOverviewAndBottleneckAnalysis"),
    DETECTION_OF_INITIALIZATION_PERIODS("DetectionOfInitializationPeriods"),
    DETECTION_OF_HIGH_LOAD_PERIODS("DetectionOfHighLoadPeriods"),
    GENERAL_DETECTION_INCLUDING_INITIALIZATION_AND_HIGH_LOAD_PERIODS_WITH_PEAK_WRITING_ANALYSIS("GeneralDetectionIncludingInitializationAndHighLoadPeriodsWithPeakWritingAnalysis"),
    ADVANCED_AND_DETAILED_GENERAL_DETECTION("AdvancedAndDetailedGeneralDetection"),
    PEAK_WRITING_ANALYSIS("PeakWritingAnalysis"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
