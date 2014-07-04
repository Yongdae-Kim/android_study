package kr.ac.jejunu.capston.attendanceadmin.time;

import java.util.Calendar;

public class CurrentTime {

	private final String[] weeks = { null, "일", "월", "화", "수", "목", "금", "토" };
	private Calendar calendar;

	public CurrentTime() {
		calendar = Calendar.getInstance();
	}

	public String getDayOfWeek() {
		return weeks[calendar.get(Calendar.DAY_OF_WEEK)];
	}

	public int getMonth() {
		return calendar.get(Calendar.MONTH) + 1;
	}

	public int getHourOfDay() {
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	public int getMinute() {
		return calendar.get(Calendar.MINUTE);
	}

	public int getSecond() {
		return calendar.get(Calendar.SECOND);
	}

	public String getNow() {
		return getHourOfDay() + ":" + getMinute() + ":" + getSecond();
	}
}
