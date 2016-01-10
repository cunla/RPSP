package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "BottlenecksDetectionResult")
public class BottlenecksDetectionResult {

    private String result;

    public BottlenecksDetectionResult() {
    }

    public BottlenecksDetectionResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((this.result == null) ? 0 : this.result.hashCode());
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
        BottlenecksDetectionResult other = (BottlenecksDetectionResult) obj;
        if (result == null) {
            if (other.result != null)
                return false;
        } else if (!result.equals(other.result))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BottlenecksDetectionResult [result=" + result + "]";
    }

	/*
     * ====================================================================================================================================
Statistics were found between the times: 2010/04/21 13:03:49.267 GMT ----> 2010/04/25 11:57:26.662 GMT

====================================================================================================================================
System overview of cluster: Lod
WAN throughput from cluster                                           : 0.0108003 Megabits/sec
                                                          Max Value: 0.0115203 Megabits/sec
Total incoming writes rate for cluster                                : 0 Megabytes/sec
                                                          Max Value: 0 Megabytes/sec
Incoming IOs rate for cluster                                         : 9.90688 IOs/sec
                                                          Max Value: 9.90688 IOs/sec
Total incoming writes rate for cluster while replicating              : 0 Megabytes/sec
                                                          Max Value: 0 Megabytes/sec
Incoming IOs rate for cluster while replicating                       : 17.9002 IOs/sec
                                                          Max Value: 17.9002 IOs/sec
Initialization output rate for cluster (average over all period)      : 0 Megabytes/sec
                                                          Max Value: 0 Megabytes/sec
Compression CPU utilization                                        : 0 %
                                                          Max Value: 0 %
Compression not used
--------------------------------------------------------------------------------
System overview of cluster: Ramle
WAN throughput from cluster                                           : 0.0146336 Megabits/sec
                                                          Max Value: 0.0151153 Megabits/sec
Total incoming writes rate for cluster                                : 0 Megabytes/sec
                                                          Max Value: 0 Megabytes/sec
Incoming IOs rate for cluster                                         : 0 IOs/sec
                                                          Max Value: 0 IOs/sec
Total incoming writes rate for cluster while replicating              : 0 Megabytes/sec
                                                          Max Value: 0 Megabytes/sec
Incoming IOs rate for cluster while replicating                       : 0 IOs/sec
                                                          Max Value: 0 IOs/sec
Initialization output rate for cluster (average over all period)      : 0 Megabytes/sec
                                                          Max Value: 0 Megabytes/sec
Compression CPU utilization                                        : 0 %
                                                          Max Value: 0 %
Compression not used
--------------------------------------------------------------------------------

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Bottleneck found at the cluster: Lod
        Writing to the local journal volume was slow during this period.
        Delay value is: 0.00108308

Bottlenecks detection file successfully written to the disk.

	 */
}
