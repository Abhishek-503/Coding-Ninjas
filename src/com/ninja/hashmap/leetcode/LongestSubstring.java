package com.ninja.hashmap.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstring {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(LongestSubstringSol.findLongest(s));
		sc.close();
	}
}

class LongestSubstringSol{
	public static int findLongest(String input) {
		int ans = 0;
		int[] arr = new int[128];
		for (int i = 0,j = 0; i < input.length(); i++) {
			j = Math.max(arr[input.charAt(i)], j);
			ans = Math.max(ans, i-j+1);
			arr[input.charAt(i)] = i+1;
		}
		return ans;
	}
	
	public static int findLongest2(String input) {
		int ans = 0;
		Map<Character,Integer> map = new HashMap<>();
		for (int i = 0,j = 0; i < input.length(); i++) {
			if(map.containsKey(input.charAt(i))) {
				j = Math.max(map.get(input.charAt(i)), j);
			}			
			ans = Math.max(ans, i-j+1);
			map.put(input.charAt(i), i+1);
		}
		return ans;
	}
}
