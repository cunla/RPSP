package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum SplitterType {
    CLARIION("Clariion"),
    SYMMETRIX("Symmetrix"),
    VPLEX_ARRAY("VplexArray"),
    VPLEX_DIRECTOR("VplexDirector"),
    VNX2E("VNX2e"),
    VNX2E_SP("VNX2eSP"),
    ESX_CLUSTER("EsxCluster"),
    ESX("Esx"),
    IO_FILTER("IOFilter"),
    IO_FILTER_CLUSTER("IOFilterCluster"),
    SYMMETRIX_ARRAY("SymmetrixArray"),
    SYMMETRIX_DIRECTOR("SymmetrixDirector"),
    SCALE_IO("ScaleIo"),
    UNKNOWN("Unknown");

    public boolean isSingleSplitter() {
        return this.equals(SplitterType.VPLEX_DIRECTOR)
            || this.equals(SplitterType.SYMMETRIX_DIRECTOR)
            || this.equals(SplitterType.VNX2E_SP)
            || this.equals(SplitterType.ESX)
            || this.equals(SplitterType.IO_FILTER);
    }

    public boolean isAggregatedSplitter() {
        return this.equals(SplitterType.SYMMETRIX_ARRAY)
            || this.equals(SplitterType.VNX2E)
            || this.equals(SplitterType.ESX_CLUSTER)
            || this.equals(SplitterType.IO_FILTER_CLUSTER)
            || this.equals(SplitterType.VPLEX_ARRAY);

    }

    private String name;

    public String toString() {
        return name;
    }

}
