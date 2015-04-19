package com.emc.rpsp.domain;

import com.emc.rpsp.StatesConsts;

/**
 * Created by morand3 on 2/19/2015.
 */
public class ReportLine {
	private String country;
	private int year;
	private int month;
	private int stateRemote;
	private int stateLocal;
	private int stateSource;

	public ReportLine(String country, int year, int month) {
		this.country = country;
		this.year = year;
		this.month = month;
	}

	public ReportLine(VmCount vmData) {
		this(vmData.getCountry(), vmData.getYear(), vmData.getMonth());
		this.setState(vmData.getState(), vmData.getTotalVms());
	}

	public ReportLine(int year, int month, String country, int stateSource,
	        int stateLocal, int stateRemote) {
		this(country, year, month);
		this.stateSource = stateSource;
		this.stateLocal = stateLocal;
		this.stateRemote = stateRemote;
	}

	public void setState(String state, int count) {
		if (StatesConsts.STATE_SOURCE.equals(state))
			setStateSource(count);
		else if (StatesConsts.STATE_LOCAL.equals(state))
			setStateLocal(count);
		else if (StatesConsts.STATE_REMOTE.equals(state))
			setStateRemote(count);
	}

	public void setStateRemote(int stateRemote) {
		this.stateRemote = stateRemote;
	}

	public void setStateLocal(int stateLocal) {
		this.stateLocal = stateLocal;
	}

	public void setStateSource(int stateSource) {
		this.stateSource = stateSource;
	}

	public static String csvTitle() {
		return "month,year,country,source,local,remote";
	}

	public String asCsv() {
		return String.format("%d,%d,%s,%d,%d,%d", month, year, country,
		        stateSource, stateLocal, stateRemote);
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

	public int getStateRemote() {
		return stateRemote;
	}

	public int getStateLocal() {
		return stateLocal;
	}

	public int getStateSource() {
		return stateSource;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ReportLine that = (ReportLine) o;

		if (month != that.month)
			return false;
		if (year != that.year)
			return false;
		if (country != null ? !country.equals(that.country)
		        : that.country != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = country != null ? country.hashCode() : 0;
		result = 71 * result + year;
		result = 31 * result + month;
		return result;
	}

	public void addPeriodClusterSample(int sampleNumber, int stateSource,
	        int stateLocal, int stateRemote) {
		this.stateSource = (this.stateSource * (sampleNumber - 1) + stateSource)
		        / sampleNumber;
		this.stateLocal = (this.stateLocal * (sampleNumber - 1) + stateLocal)
		        / sampleNumber;
		this.stateRemote = (this.stateRemote * (sampleNumber - 1) + stateRemote)
		        / sampleNumber;
	}
}
