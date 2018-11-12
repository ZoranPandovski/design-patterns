//package com.nk.springboot.designpatterns.Factory;

public class Divide extends Calculator {

	@Override
	public int calculate(){
		// TODO Auto-generated method stub
		if (b == 0)
		{
			throw new ArithmeticException("Error. Cannot divide by zero");
		}
		else
		{
			return a / b;
		}
	}

}
