/*Inp:foo bar
barfoothefoobarman
Out:0 9 */
package com.ninja.hashmap.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSubString {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static String[] takeInput() throws IOException {

		String[] strNums;
		strNums = br.readLine().split("\\s");
		return strNums;
	}

	public static void printArray(List<Integer> arr) {
		if(arr.size()==0) {
			System.out.println("No SubString found");
			return;
		}
		for (int element : arr) {
			System.out.print(element + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		String[] words = takeInput();
		String line = br.readLine();
		printArray(FindSubStringSol.FindSubString(line, words));

	}

}

class FindSubStringSol {
	public static List<Integer> FindSubString(String line, String[] words){
		List<Integer> list = new ArrayList<Integer>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			String w = words[i];
			map.put(w, map.containsKey(w)?map.get(w)+1:1);
		}
		int wLen = words[0].length();
		int lLen = line.length();
		for(int i = 0;i<lLen-wLen*words.length;i++) {
			HashMap<String, Integer> copy = new HashMap<>(map);
			for(int j = 0; j<wLen;j++) {
				String s = line.substring(i+j*wLen, i+j*wLen+wLen);
				if(copy.containsKey(s)) {
					if(copy.get(s)==1) {
						copy.remove(s);
					}
					else {
						map.put(s, map.get(s)-1);
					}
					if(copy.isEmpty()) {
						list.add(i);
						break;
					}
				}
				else {
					break;
				}
			}
		}
		return list;
	}
}

