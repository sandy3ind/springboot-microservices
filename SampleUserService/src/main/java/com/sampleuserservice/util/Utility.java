package com.sampleuserservice.util;

import java.util.Random;

public class Utility {

	public static int getVerificationCode() {
		int max = 99999;
		int min = 10000;
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
