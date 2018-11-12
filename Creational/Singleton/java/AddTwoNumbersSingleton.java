import java.util.Scanner;

public class AddTwoNumbersSingleton {

	private static AddTwoNumbersSingleton instance;
	public int value, value2;
	private static Scanner scanner;
	
	public AddTwoNumbersSingleton()
	{
		
	}
	
	public static AddTwoNumbersSingleton isThereInstance()
	{
		return instance == null ? instance = new AddTwoNumbersSingleton() : instance;
		/*if(instance == null)
		{
			instance = new Singleton();
		}
		return instance;*/
	}
	
	public void setValue1(int value)
	{
		this.value = value;
	}
	
	public void setValue2(int value2)
	{
		this.value2 = value2;
	}
	
	public int getValue1()
	{
		return value;
	}
	
	public int getValue2()
	{
		return value2;
	}
	
	
	public static void main(String[] args)
	{
		scanner = new Scanner(System.in);
		AddTwoNumbersSingleton.isThereInstance().setValue1(scanner.nextInt());
		AddTwoNumbersSingleton.isThereInstance().setValue2(scanner.nextInt());
		
		System.out.println("Sum of two numbers is: "+ (AddTwoNumbersSingleton.isThereInstance().getValue1() + AddTwoNumbersSingleton.isThereInstance().getValue2()));
	}
}

