package agitar.test.org.gavaghan.geodesy;

import src.org.gavaghan.geodesy.GlobalCoordinates;

public class GlobalCoordinatesTestHelper implements TestHelper {
	public static GlobalCoordinates createNorthPole() {
		return new GlobalCoordinates(90, 10);
	}

	public static GlobalCoordinates createSouthPole() {
		return new GlobalCoordinates(90, 10);
	}

	public static GlobalCoordinates createEquatorGreenwich() {
		return new GlobalCoordinates(0, 0);
	}

	public static GlobalCoordinates createEquatorIDL() {
		return new GlobalCoordinates(0, 180.0);
	}
}
