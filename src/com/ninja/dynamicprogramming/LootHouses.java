package com.ninja.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LootHouses {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int[] takeInput() throws IOException {
		int n = Integer.parseInt(br.readLine().trim());

		if (n == 0) {
			return new int[0];
		}

		String[] strNums = br.readLine().trim().split("\\s");
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(strNums[i]);
		}

		return arr;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr = takeInput();
		System.out.println(LootHousesSol.maxMoneyLooted(arr));
	}
}

class LootHousesSol {

	public static int maxMoneyLooted(int arr[]){
		return getMaxMoney(arr, arr.length,0);
	}
	public static int getMaxMoney(int arr[], int n,int index){
		if( arr.length==0 || index>=arr.length)
			return 0;
		int op1=arr[index]+getMaxMoney(arr,n,index+2);
		int op2=getMaxMoney(arr,n,index+1);
		return Math.max(op1,op2);
	}
	public static int getMaxMoney(int arr[], int n){
		if(arr.length==0)
			return 0;
		int storage[]=new int[arr.length];
		storage[0]=arr[0];
		storage[1]=Math.max(arr[1],storage[0]);
		for(int i=2;i<storage.length;i++){
			storage[i]=Math.max(arr[i]+storage[i-2],storage[i-1]);
		}
		return storage[storage.length-1];
	}

}