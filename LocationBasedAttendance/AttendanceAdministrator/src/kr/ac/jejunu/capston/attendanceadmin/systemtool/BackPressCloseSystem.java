package kr.ac.jejunu.capston.attendanceadmin.systemtool;

import android.app.Activity;

public class BackPressCloseSystem {

	private long backKeyPressedTime = 0;
	private ToastSystem toast;

	private Activity mContext;

	public BackPressCloseSystem(Activity context) {
		this.mContext = context;
	}

	public void onBackPressed() {
		if (isAfter2Seconds()) {
			backKeyPressedTime = System.currentTimeMillis();
			toast = new ToastSystem(mContext, "\'뒤로\'버튼을 한번 더 누르시면 종료됩니다.");
			return;
		}

		if (isBefore2Seconds()) {
			programShutdown();
			toast.toastCancel();
		}
	}

	private Boolean isAfter2Seconds() {
		return System.currentTimeMillis() > backKeyPressedTime + 2000;
	}

	private Boolean isBefore2Seconds() {
		return System.currentTimeMillis() <= backKeyPressedTime + 2000;
	}

	private void programShutdown() {
		mContext.moveTaskToBack(true);
		mContext.finish();
		android.os.Process.killProcess(android.os.Process.myPid());
		System.exit(0);
	}

}
