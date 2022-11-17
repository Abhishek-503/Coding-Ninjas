package com.ninja.practice;


/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Sort01
{
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

            int[] input = takeInput();
            Solution.sortZeroesAndOne(input);
            printArray(input);

            t -= 1;
        }
    }
}
class Solution {  

    public static void sortZeroesAndOne(int[] arr) {
    	//Your code goes here
        // for(int i=0;i<arr.length-1;i++){
        //     for(int j = i+1;j<arr.length;j++){
        //         if(arr[i]>arr[j]){
        //             int temp = arr[j];
        //             arr[j] = arr[i];
        //             arr[i] = temp;
        //             break;
        //         }
        //     }
        // }
        
        int count = 0; // counts the no of zeros in arr
     	int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                count++;
        }
 
        // loop fills the arr with 0 until count
        for (int i = 0; i < count; i++)
            arr[i] = 0;
 
        // loop fills remaining arr space with 1
        for (int i = count; i < n; i++)
            arr[i] = 1;
    }
}

