package kr.ac.jejunu.softlab.backupsystem.observer;

import kr.ac.jejunu.softlab.backupsystem.callback.CallBack;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkObserver {

	private Context context;
	private NetworkInfo mobile, wifi;

	public NetworkObserver(Context context) {
		this.context = context;
		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		mobile = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
	}

	public void observe(CallBack callBack) {
		if (isNetworkAvailable())
			callBack.callBackMethod(null);
		else
			showWarningToast();
	}

	private Boolean isNetworkAvailable() {
		if (mobile.isConnected() || wifi.isConnected())
			return true;
		else
			return false;
	}

	private void showWarningToast() {
	}
}
