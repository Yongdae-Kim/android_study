package kr.ac.jejunu.capston.attendancecheck.location.criteria;

import android.location.LocationManager;

public class Gps {
	private LocationManager locManager;

	public Gps(LocationManager locManager) {
		this.locManager = locManager;
	}

	public Boolean isConnected() {
		return locManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
	}

}
