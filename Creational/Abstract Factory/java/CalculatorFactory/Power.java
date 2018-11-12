//package com.nk.springboot.designpatterns.Factory;

public class Power extends Calculator {

	@Override
	public int calculate() throws Exception {
		return (int)Math.pow(a, b);
	}

}
