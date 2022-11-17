package com.ninja.practice;

public class ReverseIndividualWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello, I am Aadil!";
//		int start = 0;
//		int end = 0;
//        String s = "";
//        for(int i=0;i<str.length();i++){
//            if(str.charAt(i)==' '){
//            	
//            	end = i-1;
//            	for(int j=end;j>=start;j--) {
//            		s = s+str.charAt(j);
//            	}
//            	s = s+" ";
//                start = i+1;
//            }   
//        }
//        for(int j=str.length()-1;j>=start;j--) {
//    		s = s+str.charAt(j);
//    	}
//        System.out.println(s);
		String[] s = str.split(" ");
		String op = "";
		for (int i = 0; i < s.length-1; i++) {
			StringBuffer sb = new StringBuffer(s[i]);
			op = op+sb.reverse()+" ";
		}
		op = op+(new StringBuffer(s[s.length-1])).reverse();
		System.out.println(op);
	}

}
