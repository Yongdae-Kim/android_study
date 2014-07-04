package agitar.test.org.gavaghan.geodesy;

import src.org.gavaghan.geodesy.Ellipsoid;

public class AgitarTestHelper implements TestHelper {
	public static Ellipsoid createWGS84Ellipsoid() {
		return Ellipsoid.WGS84;
	}
}
