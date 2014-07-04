package kr.ac.jejunu.capston.attendanceserver.dataheader;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.ac.jejunu.capston.attendanceserver.calc.AttendanceCalculator;
import kr.ac.jejunu.capston.attendanceserver.calc.DistanceCalculable;
import kr.ac.jejunu.capston.attendanceserver.calc.DistanceCalculator1;
import kr.ac.jejunu.capston.attendanceserver.datafactory.SendData;
import kr.ac.jejunu.capston.common.AttendanceData;

public class AttendanceCheck implements SendData {

	private AttendanceData data;
	Map<String, AttendanceData> attDataMap;

	public AttendanceCheck(AttendanceData data,
			Map<String, AttendanceData> attDataMap) {
		this.data = data;
		this.attDataMap = attDataMap;
	}

	@Override
	public String getDataHeader() {
		return "AttendanceResult";
	}

	@Override
	public Serializable getData() {
		boolean attendanceResult = getAttendanceResult(data.getLocations(),
				new DistanceCalculator1());

		if (attendanceResult == false) {
			attDataMap.put(data.getPhoneNum(), data);
		}
		// after day revise the false to true, now that is test case

		return attendanceResult;
	}

	private Boolean getAttendanceResult(double[] locationInfo,
			DistanceCalculable calc) {
		return new AttendanceCalculator(locationInfo, calc)
				.getAttendacneResult();
	}
}
