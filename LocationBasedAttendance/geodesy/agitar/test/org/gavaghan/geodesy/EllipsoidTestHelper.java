package agitar.test.org.gavaghan.geodesy;

import src.org.gavaghan.geodesy.Ellipsoid;

public class EllipsoidTestHelper implements TestHelper {
	public static Ellipsoid createWGS84() {
		return Ellipsoid.WGS84;
	}

	public static Ellipsoid createSphere() {
		return Ellipsoid.Sphere;
	}

	public static Ellipsoid createGRS80() {
		return Ellipsoid.GRS80;
	}
}
