package kr.ac.jejunu.softlab.backupsystem.provider;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

public class PackageDataProvider implements DataProvider {

	private List<String> packDataList = new ArrayList<String>();

	public PackageDataProvider(Context context) {

		PackageManager pm = context.getPackageManager();
		List<ApplicationInfo> packs = pm
				.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES
						| PackageManager.GET_DISABLED_COMPONENTS);

		for (ApplicationInfo app : packs) {
			String appName = app.loadLabel(pm).toString();
			String packName = app.packageName;

			packDataList.add(getFormattedString(appName, packName));
		}
	}

	private String getFormattedString(String appName, String packName) {
		return "\nAppName: " + appName + " \nPackName: " + packName + "\n";
	}

	@Override
	public List<String> getDataList() {
		return packDataList;
	}

}
