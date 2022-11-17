package com.ninja.oops.interfaces;

public class Car implements VehicleInterface, CarInterface{

    @Override
    public boolean isMotorized(){
      return true;
    }

    @Override
    public String getCompany(){
      return "";
     }

     @Override
     public int numGears(){
       return 5;
      }

      void print(){
          System.out.println(PI);
      }

	@Override
	public int getNoofTyres() {
		// TODO Auto-generated method stub
		return 0;
	}
      
}
