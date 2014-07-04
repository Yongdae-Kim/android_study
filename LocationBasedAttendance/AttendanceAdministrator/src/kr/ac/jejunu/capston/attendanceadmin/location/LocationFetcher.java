package kr.ac.jejunu.capston.attendanceadmin.location;

import kr.ac.jejunu.capston.attendanceadmin.callback.CallBack;
import android.content.Context;
import android.location.Location;

public class LocationFetcher {

	private double[] locations = new double[2];

	public LocationFetcher(Context mContext) {
		LocationTracker locFactory = new LocationTracker(mContext,
				locationCallBack);
		locFactory.setLocation();
	}

	private CallBack locationCallBack = new CallBack() {
		@Override
		public void callBackMethod(Object obj) {
			Location myLocation = (Location) obj;
			if (myLocation != null)
				setLocationPoint(myLocation);
		}
	};

	private void setLocationPoint(Location myLocation) {
		locations[0] = myLocation.getLatitude();
		locations[1] = myLocation.getLongitude();
	}

	public double[] getLocations() {
		return locations;
	}

}
