package kr.ac.jejunu.capston.attendancecheck.location.criteria;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Network {
	private ConnectivityManager cManager;

	public Network(Context mContext) {
		cManager = (ConnectivityManager) mContext
				.getSystemService(Context.CONNECTIVITY_SERVICE);
	}

	public Boolean isConnected() {
		NetworkInfo mobile = cManager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		NetworkInfo wifi = cManager
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

		return mobile.isConnected() || wifi.isConnected();
	}
}
