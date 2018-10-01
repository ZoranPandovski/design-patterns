using System;
public interface DispenseChain {

    void setNextChain(DispenseChain nextChain);
	
	void dispense(Currency cur);
}


public class Currency {

	private int amount;
	
	public Currency(int amt){
		this.amount=amt;
	}
	
	public int getAmount(){
		return this.amount;
	}
}

public class Dollar50Dispenser : DispenseChain {

	private DispenseChain chain;
	
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}
	
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 50){
			int num = cur.getAmount()/50;
			int remainder = cur.getAmount() % 50;
			System.Console.WriteLine("Dispensing "+num+" 50$ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}

}

public class Dollar20Dispenser : DispenseChain{

	private DispenseChain chain;
	
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	public void dispense(Currency cur) {
		if(cur.getAmount() >= 20){
			int num = cur.getAmount()/20;
			int remainder = cur.getAmount() % 20;
			System.Console.WriteLine("Dispensing "+num+" 20$ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}

}

public class Dollar10Dispenser : DispenseChain {

	private DispenseChain chain;
	
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	public void dispense(Currency cur) {
		if(cur.getAmount() >= 10){
			int num = cur.getAmount()/10;
			int remainder = cur.getAmount() % 10;
			System.Console.WriteLine("Dispensing "+num+" 10$ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}

}

public class ATMDispenseChain {

	private DispenseChain c1;

	public ATMDispenseChain() {
		// initialize the chain
		this.c1 = new Dollar50Dispenser();
		DispenseChain c2 = new Dollar20Dispenser();
		DispenseChain c3 = new Dollar10Dispenser();

		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);
	}

	public static void Main(string[] args) {
		ATMDispenseChain atmDispenser = new ATMDispenseChain();
		while (true) {
			int amount = 0;
			Console.WriteLine("Enter amount to dispense");
			amount = Convert.ToInt32(Console.ReadLine());
			if (amount % 10 != 0) {
				Console.WriteLine("Amount should be in multiple of 10s.");
				return;
			}
			// process the request
			atmDispenser.c1.dispense(new Currency(amount));
		}
	}

}
