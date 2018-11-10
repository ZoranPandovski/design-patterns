//package com.nk.springboot.designpatterns.Factory;

import java.util.Scanner;

public class CreateCalculator {

	public static void main(String[] args) throws Exception
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the operation to perform: ");
        String op = scanner.nextLine();
        
        System.out.println("Enter two numbers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        GetCalcFactory calc = new GetCalcFactory();
        Calculator c = calc.getCalc(op);
        c.a = a;
        c.b = b;
        int result = c.calculate();
        System.out.println("Result: "+ result);
		scanner.close();
	}

}
