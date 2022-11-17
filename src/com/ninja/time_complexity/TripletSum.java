package com.ninja.time_complexity;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TripletSum {

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
			System.out.println(TripletSumSol.tripletSum(arr, num));

			t -= 1;
		}
	}
}

class TripletSumSol {	

	public static int tripletSum(int[] arr, int num) {
		//Your code goes here
		int sum = 0;

		for(int i = 0;i<arr.length-2;i++){
			for(int j = i+1;j<arr.length-1;j++){
				for(int k = j+1;k<arr.length;k++){
					if((arr[i]+arr[j]+arr[k]) == num){
						System.out.println(arr[i]+","+arr[j]+","+arr[k]);
						sum = sum + 1;
					}
				}
			}
		}
		//		for(int i = 0;i<arr.length-2;i++){
		//            for(int j = i+1;j<arr.length-1;j++){
		//            	int temp = num - arr[i] - arr[j];
		//            	int k = j+1;
		//            	while(k<arr.length) {
		//            		if(arr[k]==temp)
		//            			sum += 1;
		//            		k++;
		//            	}
		//            }
		//        }
		//		Arrays.sort(arr);
		//		for(int i = 0;i<arr.length-2;i++){
		//			int l = i+1;
		//			int r = arr.length-1;
		//			while(l<r) {
		//				if((arr[i]+arr[l]+arr[r])>num) {
		//					r = r - 1;
		//				}
		//				else if((arr[i]+arr[l]+arr[r])<num) {
		//					l = l + 1;
		//				}
		//				else {
		//					System.out.println(arr[i]+","+arr[l]+","+arr[r]);
		//					sum = sum + 1;
		//					r--;
		//					l++;
		//				}
		//			}
		//		}
		System.out.println("-------------------------");
		Arrays.sort(arr);

		for (int i = 0;
				i < arr.length - 1; i++) {
			// initialize left and right
			int l = i + 1;
			int r = arr.length - 1;
			int x = arr[i];
			while (l < r) {
				if (x + arr[l] + arr[r] == num) {
					// print elements if it's
					// sum is given sum.
					System.out.println(
							x + " " + arr[l] + " "
									+ arr[r]);
					sum = sum+1;
					l++;
					r--;
				}

				// If sum of three elements
				// is less than 'sum' then
				// increment in left
				else if (x + arr[l] + arr[r] < num)
					l++;

				// if sum is greater than
				// given sum, then decrement
				// in right side
				else
					r--;
			}
		}
		return sum;
	}

	public static boolean binarySearch(int[] arr, int x) {
		//Your code goes here
		int start = 0;
		int end = arr.length-1;
		int mid =0;
		while(start<=end){
			mid = (start+end)/2;
			if(arr[mid]>x){
				end = mid-1;
			}
			else if(arr[mid]<x){
				start = mid+1;
			}
			else {
				return true;
			}
		}
		return false;
	}

	public static int tripletSum3(int[] arr, int num) {
		//Your code goes here
		int i,j,k,c=0,n;
		n=arr.length;
		Arrays.sort(arr);
		for(i=0;i<n-2;i++)
		{
			j=i+1;k=n-1;
			while(j<k)
			{
				if(arr[i]+arr[j]+arr[k]<num)
				{
					j++;
				}
				else if(arr[i]+arr[j]+arr[k]>num)
				{
					k--;
				}
				else
				{
					if(arr[j]!=arr[k])
					{
						int d=1;

						while((arr[j]==arr[j+1]) && ((j+1)<k))
						{
							d++;
							j++;
						}
						int e=1;
						while((arr[k]==arr[k-1]) && (j<(k-1)))
						{
							e++;
							k--;
						}
						if(arr[j]!=arr[j+1] && arr[k]!=arr[k-1])
						{
							k--;
						}
						c=c+(d*e);
					}

					else
					{
						int f=k-j+1;
						j=j+f-1;
						c=c+((f*(f-1))/2);
					}
				}

			}
		}
		return c;
	}
}
