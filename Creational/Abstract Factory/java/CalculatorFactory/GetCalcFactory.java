//package com.nk.springboot.designpatterns.Factory;

public class GetCalcFactory {

	public Calculator getCalc(String operation)
	{
		operation = operation.toLowerCase();
		if(operation.equals("add"))
		{
			return new Add();
		}
		else if(operation.equals("subtract"))
		{
			return new Subtract();
		}
		else if(operation.equals("multiply"))
		{
			return new Multiply();
		}
		else if(operation.equals("divide"))
		{
			return new Divide();
		}
		else if(operation.equals("power"))
		{
			return new Power();
		}
		else
		{
			return null;
		}
	}
}
