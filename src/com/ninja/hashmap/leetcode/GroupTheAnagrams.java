package com.ninja.hashmap.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GroupTheAnagrams {
	public  ArrayList<ArrayList<String>> groupTheAnagrams(String[] arr) {
		Map<String,ArrayList<String>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			char[] ch = arr[i].toCharArray();
			Arrays.sort(ch);
			String s = String.valueOf(ch);
			if(!map.containsKey(s)) {
				map.put(s, new ArrayList<>());
			}
			map.get(s).add(arr[i]);
		}
		return new ArrayList<>(map.values());
	}
	
}
