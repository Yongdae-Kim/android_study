package kr.ac.jejunu.capston.common;

import java.io.Serializable;

public class AdministratorData implements Serializable {

	private static final long serialVersionUID = -5637260278875972837L;

	private String time;
	private double[] locations;

	public AdministratorData(String time, double[] locations) {
		this.time = time;
		this.locations = locations;
	}

	public String getTime() {
		return time;
	}

	public double[] getLocations() {
		return locations;
	}

}