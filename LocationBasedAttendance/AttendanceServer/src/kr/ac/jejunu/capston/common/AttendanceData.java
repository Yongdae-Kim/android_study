package kr.ac.jejunu.capston.common;

import java.io.Serializable;

public class AttendanceData implements Serializable {

	private static final long serialVersionUID = -7045049075868320972L;
	private String studentNum, studentName, phoneNum, time;
	private double[] locations;

	public AttendanceData(String studentNum, String studentName,
			String phoneNum, String time, double[] locations) {
		this.studentNum = studentNum;
		this.studentName = studentName;
		this.phoneNum = phoneNum;
		this.time = time;
		this.locations = locations;
	}

	public String getStudentNum() {
		return studentNum;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getTime() {
		return time;
	}

	public double[] getLocations() {
		return locations;
	}

	@Override
	public boolean equals(Object other) {
		return this.phoneNum.equals(((AttendanceData) other).getPhoneNum());
	}
}
