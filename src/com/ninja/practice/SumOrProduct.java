package com.ninja.practice;

/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class SumOrProduct
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        if(c==1){
            int sum = 0;
            for(int i=1;i<=n;i++){
                sum = sum+i;
            }
            System.out.println(sum);
        }
        else if(c==2){
            int p = 1;
            for(int i=1;i<=n;i++){
                p = p*i;
            }
            System.out.println(p);
        }
        else{
            System.out.println(-1);
        }
	}
}
