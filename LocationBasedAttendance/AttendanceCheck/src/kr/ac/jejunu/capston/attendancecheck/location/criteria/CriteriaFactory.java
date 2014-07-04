package kr.ac.jejunu.capston.attendancecheck.location.criteria;

import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;

public class CriteriaFactory {

	private Gps gps;
	private Network network;

	public CriteriaFactory(Context mContext, LocationManager locationManager) {
		gps = new Gps(locationManager);
		network = new Network(mContext);
	}

	public Criteria getCriteria() {

		Criteria criteria = new Criteria();
		criteria.setPowerRequirement(Criteria.POWER_LOW); // 전원 소비량
		criteria.setAltitudeRequired(false); // 고도, 높이 값을 얻어 올지를 결정
		criteria.setBearingRequired(false); // provider 기본 정보
		criteria.setSpeedRequired(false); // 속도
		criteria.setCostAllowed(true); // 위치 정보를 얻어 오는데 들어가는 금전적 비용

		if (gps.isConnected())
			criteria.setAccuracy(Criteria.ACCURACY_FINE);
		else if (network.isConnected())
			criteria.setAccuracy(Criteria.ACCURACY_COARSE);

		return criteria;
	}
}
