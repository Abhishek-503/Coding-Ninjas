package com.ninja.practice;

/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class TermsOfAP
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int count = 0;
        int i = 1;
        while(count<x){
            int a = 3*i+2;
            if(a%4!=0){
                if(x-1==count){
                    System.out.print(a);
                }
                else{
                    System.out.print(a+" ");
                }
                count++;
            }
            i++;
        }
        
	}
}
