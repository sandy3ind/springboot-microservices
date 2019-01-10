package com.samplerestaurantservice.util;

public class GoogleMapUtility {

	/**
	 * Calculate Distance between Lats/Lons
	 * 
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return
	 */
	public static double calculateDistance(double lat1, double lng1, double lat2, double lng2) {
		final int R = 6371; // Radius of the earth in KM	 
		double latDistance = toRad(lat2-lat1);
		double lonDistance = toRad(lng2-lng1);
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + 
		Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) * 
		Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double distance = R * c;
		return distance;
	}
	private static double toRad(double value) {
		return value * Math.PI / 180;
	}
}
