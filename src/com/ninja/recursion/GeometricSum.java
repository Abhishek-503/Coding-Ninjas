package com.ninja.recursion;

import java.text.DecimalFormat;
import java.util.Scanner;

public class GeometricSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		double ans = GeometricSumSol.findGeometricSum(k);
		DecimalFormat dec = new DecimalFormat("#0.00000");
		System.out.println(dec.format(ans));
	}

}

class GeometricSumSol {

	public static double findGeometricSum(int k){
		if(k==0) {
			return 1;
		}
		return 1/Math.pow(2, k) + findGeometricSum(k-1);
		
	}
}
