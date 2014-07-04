package kr.ac.jejunu.capston.attendanceserver.calc;

public class DistanceCalculator2 implements DistanceCalculable {

	@Override
	public double getDistance(double lat1, double lon1, double lat2, double lon2) {
		// GeodeticCalculator geoCalc = new GeodeticCalculator();
		// Ellipsoid reference = Ellipsoid.WGS84;
		//
		// GlobalPosition userPos = new GlobalPosition(lat1, lon1, 0.0); //
		// Point
		// GlobalPosition pointA = new GlobalPosition(lat2, lon2, 0.0); // Point
		//
		// return geoCalc.calculateGeodeticCurve(reference, userPos, pointA)
		// .getEllipsoidalDistance();
		// // Distance between Point A and Point B
		return 0;
	}
}