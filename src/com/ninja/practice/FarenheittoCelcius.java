package com.ninja.practice;

/******************************************************************************
0 <= S <= 90
S <= E <=  900
0 <= W <= 80 

*******************************************************************************/
import java.util.*;
public class FarenheittoCelcius
{
	
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int E = sc.nextInt();
        int W = sc.nextInt();
        if((0<=S && S<=90) && (S<=E && E<=900) && (0<=W && W<=80)){
            while(S<=E){
               
                int C =(int)((S-32)*((double)5/9));
                System.out.println(S+" "+C);
                S+=W;
            }
        }
        
    }

}
