package com.ninja.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PairWithDifferenceK {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int k = Integer.parseInt(br.readLine());
		System.out.println(PairWithDifferenceKSol.getPairsWithDifferenceK(arr, k));
	}
}

class PairWithDifferenceKSol {

	public static int getPairsWithDifferenceK(int arr[], int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i:arr) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			}
			else {
				map.put(i, 1);
			}
		}
		int ans = 0;
		for(int key: map.keySet()) {
			int temp = key+k;
            int temp2 = key-k;
			if((map.containsKey(temp) && map.get(key)>0)) {
				ans += map.get(temp)*map.get(key);
				map.put(key, 0);
			}
			if((map.containsKey(temp2) && map.get(key)>0)) {
				ans += map.get(temp2)*map.get(key);
				map.put(key, 0);
			}
		}
		if(map.size()==1 && k==0)
			return arr[0]*(arr[0]-1)/2;
		return ans;
	}
}