package com.ninja.practice;

public class LeaderArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {3,4,5,61,4,5,6,};
		int n = input.length;
        boolean flag = false;
        for(int i=0;i<n-1;i++){
            int lead = input[i];
            int temp = i+1;
            while(temp<n){
                if(lead>=input[temp]){
                    flag = true;
                }
                else{
                    flag = false;
                    break;
                }
                temp++;
            }
            if(flag){
                System.out.print(lead+" ");
            }
        }
		System.out.print(input[n-1]+" ");
	}

}
