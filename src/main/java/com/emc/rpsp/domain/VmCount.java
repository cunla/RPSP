package com.emc.rpsp.domain;

/**
 * Utility class for counting VMs in sampling date
 * Created by morand3 on 12/24/2014.
 */
public class VmCount {
    private String country;
    private String state;
    private int year;
    private int month;
    private int totalVms;

    public VmCount(int year, int month, String country, String state, long totalVms) {
        this.country = country;
        this.state = state;
        this.year = year;
        this.month = month;
        this.totalVms = (int) totalVms;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public String getState() {
        return state;
    }

    public int getTotalVms() {
        return totalVms;
    }

    @Override
    public String toString() {
        return "VmCount{" +
                "country='" + country + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", state='" + state + '\'' +
                ", totalVms=" + totalVms +
                '}';
    }

    public static String csvTitle() {
        return "Year,Month,Country,State,#vms";
    }

    public String asCsv() {
        return String.format("%d,%d,%s,%s,%d", year, month, country, state, totalVms);
    }
}
