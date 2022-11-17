package com.ninja.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinStepsToOne {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine().trim());
		System.out.println(MinStepsToOneSol.countMinStepsToOne(n));
	}
}

class MinStepsToOneSol {

	public static int countMinStepsToOne(int n) {
		return steps(n, 0);
	}

	private static int steps(int n, int consecutiveMinusOnes) {
		if (n <= 1) {
			return 0;
		}
		int minSteps = Integer.MAX_VALUE;
		if (consecutiveMinusOnes < 2) {
			minSteps = 1 + steps(n - 1, consecutiveMinusOnes + 1);
		}
		if (n % 2 == 0) {
			minSteps = Math.min(minSteps, 1 + steps(n / 2, 0));
		}
		if (n % 3 == 0) {
			minSteps = Math.min(minSteps, 1 + steps(n / 3, 0));
		}
		return minSteps;
	}

	public static int countMinStepsToOne2(int n) {
		//Your code goes here
		int[] bu = new int[n+1];
		bu[0] = 0;
		bu[1] = 0;
		for(int i=2;i<=n;i++) {
			int r = 1+bu[i-1];
			if(i%2 == 0) r = Math.min(r,1+bu[i/2]);
			if(i%3 == 0) r = Math.min(r,1+bu[i/3]);
			bu[i] = r;
		}
		return bu[n];
	}

	public static int countMinStepsToOne3(int n) {

		if (n == 1) {
			return 0;
		}

		int[] minSteps = new int[n + 1];

		minSteps[1] = 0;

		for (int currStep = 2; currStep <= n; currStep++) {

			int subtractOne = Integer.MAX_VALUE;
			int divideByTwo = Integer.MAX_VALUE;
			int divideByThree = Integer.MAX_VALUE;

			subtractOne = minSteps[currStep - 1];

			if (currStep % 2 == 0) {
				divideByTwo = minSteps[currStep / 2];
			}

			if (currStep % 3 == 0) {
				divideByThree = minSteps[currStep / 3];
			}

			minSteps[currStep] = 1 + Math.min(subtractOne, Math.min(divideByTwo, divideByThree));
		}

		return minSteps[n];
	}


}