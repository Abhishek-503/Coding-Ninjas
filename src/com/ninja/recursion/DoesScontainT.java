package com.ninja.recursion;

import java.util.Scanner;

public class DoesScontainT {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String large = s.nextLine();
		String small = s.nextLine();

		System.out.println(DoesScontainTSol.checkSequence(large, small));
	}
}
class DoesScontainTSol {
	public static boolean checkSequence(String a, String b) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
		if(b.length()==0){
            return true;
        }
		
		if(b.length()!=0 && a.length()==0) {
			return false;
		}

		if(a.charAt(0)==b.charAt(0)) {
			return checkSequence(a.substring(1), b.substring(1));
		}
		else {
			return checkSequence(a.substring(1), b);
		}
	}
}