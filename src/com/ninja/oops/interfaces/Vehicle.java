package com.ninja.oops.interfaces;

public class Vehicle implements VehicleInterface{

    @Override
    public boolean isMotorized(){
      return false;
    }

    @Override
    public String getCompany(){
      return null;
    }

    void prnt(){
      System.out.println(PI);
    }

	@Override
	public int getNoofTyres() {
		// TODO Auto-generated method stub
		return 0;
	}

}
