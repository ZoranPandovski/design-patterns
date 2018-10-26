package com.chain.resposibility;

public interface DispenseChain {

void setNextChain(DispenseChain nextChain);
	
	void dispense(Currency cur);
}
