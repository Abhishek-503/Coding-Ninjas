package com.ninja.oops.interfaces;

public class VehicleUse{

    public static void main(String[] args){
        Vehicle v= new Vehicle();
        VehicleInterface vI;

        vI= new Vehicle();
        vI.getCompany();
        
        Car c = new Car();
        vI.getNoofTyres();
    }
}
