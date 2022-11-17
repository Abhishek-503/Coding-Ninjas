package com.ninja.oops;

public class Polynomial {

	int[] data = new int[5];
	/* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
	 *  then corresponding term(with specified degree and value is added into the polynomial. If the degree
	 *  is already present in the polynomial then previous coefficient is replaced by
	 *  new coefficient value passed as function argument
	*/
	public void setCoefficient(int degree, int coeff){
		while(data.length<=degree) {
			doubleCapacity();
		}
		data[degree] = coeff;
	}
	
	// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
	public void print(){
		String output = "";
		for(int i=0;i<this.data.length;i++) {
			if(this.data[i]!=0)
				output = output + this.data[i] + "x" + i + " ";
 		}
		System.out.println(output);
	}

	
	// Adds two polynomials and returns a new polynomial which has result
	public Polynomial add(Polynomial p){
		Polynomial pol = new Polynomial();
		int max = p.data.length;
		int min = this.data.length;
		Polynomial maxPol = p;
		if(max<this.data.length) {
			max = this.data.length;
			maxPol = this;
			min = p.data.length;
		} 
		pol.data = new int[max];
		int i=0;
		for(;i<min;i++) {
			pol.data[i] = this.data[i] + p.data[i];
			if(pol.data[i]!=0)
				pol.setCoefficient(i, pol.data[i]);
 		}
		for(int j = i;j<max;j++) {
			if(maxPol.data[j]!=0)
				pol.setCoefficient(j, maxPol.data[j]);
		}
		return pol;
	}
	
	// Subtracts two polynomials and returns a new polynomial which has result
	public Polynomial subtract(Polynomial p){
		Polynomial pol = new Polynomial();
		int max = p.data.length;
		int min = this.data.length;
		Polynomial maxPol = p;
		if(max<this.data.length) {
			max = this.data.length;
			maxPol = this;
			min = p.data.length;
		} 
		pol.data = new int[max];
		int i=0;
		for(;i<min;i++) {
			pol.data[i] = this.data[i] - p.data[i];
			if(pol.data[i]!=0)
				pol.setCoefficient(i, pol.data[i]);
 		}
		for(int j = i;j<max;j++) {
			if(maxPol.data[j]!=0)
				pol.setCoefficient(j, maxPol.data[j]);
		}
		return pol;	
	}
	
	// Multiply two polynomials and returns a new polynomial which has result
	public Polynomial multiply(Polynomial p){
		int max = p.data.length;
		int min = this.data.length;
		Polynomial maxPol = p;
		Polynomial minPol = this;
		if(max<this.data.length) {
			max = this.data.length;
			maxPol = this;
			minPol = p;
			min = p.data.length;
		} 
		int count = 0;
		for(int i=0;i<min;i++) {
			if(minPol.data[i]!=0) {
				count++;
			}
 		}
		Polynomial[] polList = new Polynomial[count];
		count = 0;
		for(int i=0;i<min;i++) {
			if(minPol.data[i]!=0) {
				polList[count] = new Polynomial();
				polList[count].data = new int[max+min];
				for(int j = 0;j<max;j++) {
					if(maxPol.data[j]!=0) {
						polList[count].setCoefficient(i+j, minPol.data[i]*maxPol.data[j]);
					}
				}
				count++;
			}

 		}
		
		Polynomial temp = polList[0];
		for(int i=1;i<count;i++) {
			temp = temp.add(polList[i]);
		}
		return temp;
	}
	
    private void doubleCapacity(){
        int temp[]= data;
        data= new int[2*temp.length];
        for(int i=0;i<temp.length;i++){
          data[i]=temp[i];
        }
    }

}
