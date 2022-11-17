package com.ninja.recursion;

import java.util.Scanner;

public class CountZero {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(CountZeroSol.countZerosRec(n));
//		System.out.println(1%10);
	}
}

class CountZeroSol {

	public static int countZerosRec(int input){
		if(input==0) {
			return 1;
		}
        else{
            if(input==0 || input<10) {
				return 0;
			}
            if(input%10==0) {
				return 1 + countZerosRec(input/10);
            }
            else {
                return countZerosRec(input/10);
            }
        }
	}
}