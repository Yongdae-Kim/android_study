package kr.ac.jejunu.capston.attendanceadmin.systemtool;

import android.content.Context;
import android.widget.Toast;

public class ToastSystem {

	private Toast toast;

	public ToastSystem(Context mContext, String msg) {
		toast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
		toast.show();
	}

	public void toastCancel() {
		toast.cancel();
	}
}
