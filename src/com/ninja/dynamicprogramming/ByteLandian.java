package com.ninja.dynamicprogramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
public class ByteLandian {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		Long n = Long.parseLong(br.readLine().trim());
		HashMap<Long, Long> memo = new HashMap<Long, Long>();
		System.out.println(ByteLandianSol.bytelandian(n,memo));
	}
}

class ByteLandianSol {

	public static long bytelandian(long n, HashMap<Long, Long> memo) {
        // Write your code here
		for(Long i = 1L;i<=n;i++) {
			Long a = i/2L;
	        Long b = i/3L;
	        Long c = i/4L;
	        Long sum = a+b+c;
//	        System.out.println(i+" -> "+a+" "+b+" "+c);
	        if(memo.containsKey(a)) {
	        	a = memo.get(a);
	        }
	        if(memo.containsKey(b)) {
	        	b = memo.get(b);
	        }
	        if(memo.containsKey(c)) {
	        	c = memo.get(c);
	        }
	        if((a+b+c)>sum) {
	        	memo.put(i, (a+b+c));
	        }
	        else if(sum>i){
	        	memo.put(i, sum);
	        }
	        else {
	        	memo.put(i, i);
	        }
//	        System.out.println(memo.get(i));
		}
//		System.out.println(memo.keySet());
		return memo.get(n);
       	
	}
	
	public static long bytelandian2(long n, HashMap<Long, Long> map) {
        // Write your code here
        if(n ==0|| n==1){
            return n;
        } 
        if(map.containsKey(n)){
          return map.get(n);  
        } 
        long max = Math.max(n, bytelandian(n/2,map) + bytelandian(n/3,map) + bytelandian(n/4,map));
        map.put(n,max); 
        return max;
	}

}