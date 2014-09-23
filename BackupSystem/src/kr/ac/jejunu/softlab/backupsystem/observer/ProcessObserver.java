package kr.ac.jejunu.softlab.backupsystem.observer;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;

public class ProcessObserver {

	private List<RunningAppProcessInfo> list;

	public ProcessObserver(Context context) {
		ActivityManager actMng = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);

		list = actMng.getRunningAppProcesses();
	}

	public boolean isRunningProcess(String packageName) {

		boolean isRunning = false;

		for (RunningAppProcessInfo rap : list) {
			if (rap.processName.equals(packageName)) {
				isRunning = true;
				break;
			}
		}
		return isRunning;
	}
}
