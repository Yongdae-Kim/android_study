package kr.ac.jejunu.capston.attendanceserver.calc;

public class DistanceCalculator1 implements DistanceCalculable {

	@Override
	public double getDistance(double lat1, double lon1, double lat2, double lon2) {
		double theta, dist;

		theta = lon1 - lon2;
		dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
				* Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1609.344;

		return dist;
	}

	private double deg2rad(double deg) {
		return (double) (deg * Math.PI / (double) 180d);
	}

	private double rad2deg(double rad) {
		return (double) (rad * (double) 180d / Math.PI);
	}
}