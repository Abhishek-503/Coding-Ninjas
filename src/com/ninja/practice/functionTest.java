package com.ninja.practice;

public class functionTest {

	public static void test(int[] arr) {
		System.out.println("inside "+arr);
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = 1;
		}
		arr[0] = 11;
		System.out.println("before "+arr);
		arr = new int[]{10,20};
		System.out.println("after "+arr);
	}
	public static void print(int[] arr) {
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[5];
		System.out.println(arr);
		test(arr);
		System.out.println(arr);
		print(arr);
	}

}
