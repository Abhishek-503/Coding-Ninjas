package com.ninja.oops;

public class DynamicArrayUse {

	public static void main(String[] args){
	      DynamicArray d= new DynamicArray();

	      for(int i=1;i<100;i++){
	        d.add(100+i);
	      }
	      System.out.println(d.size());
//	      System.out.println(d.get(2));
//	      d.set(3,170);
//	      System.out.println(d.get(3));
	      d.insertBetween(2,34);
	      d.insertBetween(99, 1);
	      d.insertBetween(100, 100);
	      d.insertBetween(101, 99);
	      d.insertBetween(103, 3);
	      System.out.println(d.size());
	      int i = 0;
	      while(i<d.size()){
	    	  System.out.println("index "+i+": "+d.get(i));
	    	  i++;
	      }
	      
	    }
}
