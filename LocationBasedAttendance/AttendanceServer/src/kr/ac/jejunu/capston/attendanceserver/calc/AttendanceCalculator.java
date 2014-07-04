package kr.ac.jejunu.capston.attendanceserver.calc;

public class AttendanceCalculator {

	private double distance;

	public AttendanceCalculator(double[] locationInfo, DistanceCalculable calc) {
		distance = calc.getDistance(locationInfo[0], locationInfo[1],
				33.4546752, 126.5654412);
	}

	public Boolean getAttendacneResult() {
		System.out.println("S : (distance)" + distance);

		if (distance < 20)
			return true;
		else
			return false;
	}
}
