package de.bitnoise.datasim;

public class UniqeID {

	protected static Long uniqueBaseID = 1L;

	public static Long generate() {
		synchronized (uniqueBaseID) {
			uniqueBaseID++;
		}
		return uniqueBaseID;
	}

	public static String generateAsString() {
		return generate().toString();
	}

}
