package com.ninja.time_complexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class TripletSum2 {
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }
        
        String[] strNums; 
        strNums = br.readLine().split("\\s");
        

        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {

            int[] arr = takeInput();
            int num = Integer.parseInt(br.readLine().trim());
//            System.out.println(Solution.findTriplets(arr, arr.length, num));

            t -= 1;
        }
    }
}
/*

Time Complexity: O(N^3)
Space Complexity: O(1)

Where N is the number of elements in the array.

 */


class Pair {
	int a;
	int b;
	int c;

	Pair(int p, int q, int r) {
		a = p;
		b = q;
		c = r;
	}

	public boolean equals(Object o) {
		if (o instanceof Pair) {
			Pair p = (Pair) o;
			return p.a == a && p.b == b && p.c == c;
		}
		return false;
	}

	public int hashCode() {
		return new Integer(a).hashCode() * 31 + new Integer(b).hashCode() * 32 + new Integer(c).hashCode();
	}
}
class Solution {

	public static int findTriplets(int[] arr, int n, int K)  {

		// Set to keep the track of visited triplets.
		HashSet<Pair> visited = new HashSet<>();
		int sum = 0;
//		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					// If we find a valid triplet.
					if (arr[i] + arr[j] + arr[k] == K) {
						ArrayList<Integer> triplet = new ArrayList<>();
						triplet.add(arr[i]);
						triplet.add(arr[j]);
						triplet.add(arr[k]);
						// Sorting the triplet track distinct triplets.
						Collections.sort(triplet);
						if (!visited.contains(new Pair(triplet.get(0),triplet.get(1),triplet.get(2)))) {
//							ans.add(triplet);
							sum = sum + 1;
							visited.add(new Pair(triplet.get(0),triplet.get(1),triplet.get(2)));
						}
					}
				}
			}
		}

		return sum;

	}
}
