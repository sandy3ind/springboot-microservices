package com.samplerestaurantservice.util;

import java.text.DecimalFormat;

public class Utility {

	/**
	 * Limit decimal places after period.
	 * 
	 * @param digit
	 * @return
	 */
	public static double limitDecimal(double digit, int places) {
		DecimalFormat numberFormat = new DecimalFormat("#.0");
		return Double.valueOf(numberFormat.format(digit));
	}
}
