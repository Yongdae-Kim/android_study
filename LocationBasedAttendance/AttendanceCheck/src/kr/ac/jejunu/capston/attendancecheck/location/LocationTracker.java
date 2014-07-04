package kr.ac.jejunu.capston.attendancecheck.location;

import kr.ac.jejunu.capston.attendancecheck.callback.CallBack;
import kr.ac.jejunu.capston.attendancecheck.location.criteria.CriteriaFactory;
import kr.ac.jejunu.capston.attendancecheck.systemtool.ToastSystem;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class LocationTracker implements LocationListener {
	private Context mContext;
	private CallBack callBack;

	private LocationManager locationManager;
	private CriteriaFactory factory;

	public LocationTracker(Context mContext, CallBack callBack) {
		this.mContext = mContext;
		this.callBack = callBack;

		locationManager = (LocationManager) mContext
				.getSystemService(Context.LOCATION_SERVICE);
		factory = new CriteriaFactory(mContext, locationManager);
	}

	public void setLocation() {
		String bestProvider = locationManager.getBestProvider(
				factory.getCriteria(), true);

		new ToastSystem(mContext, bestProvider + "is provider enabled : "
				+ locationManager.isProviderEnabled(bestProvider));

		locationManager.requestLocationUpdates(bestProvider, 1000, 0, this);
		Location location = locationManager.getLastKnownLocation(bestProvider);

		callBack.callBackMethod(location);
	}

	@Override
	public void onLocationChanged(Location location) {
		callBack.callBackMethod(location);
	}

	@Override
	public void onProviderDisabled(String provider) {
	}

	@Override
	public void onProviderEnabled(String provider) {
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {

	}

}
