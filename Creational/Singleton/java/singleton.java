import java.io.Serializable;

//Changing the Singleton class to Enum as it provides more flexibility of the Singleton design pattern
// Also the class implementation of Singleton will fail during serialization.
// Driver Code
public class singleton
{
	enum Singleton
	{
		INSTANCE;
		
		int value;

		public int getValue() {
			return value;
		}
		

		public void setValue(int value) {
			this.value = value;
		}
		
		
		
	}
	public static void main(String args[])
	{
		// instantiating Singleton class with variable x and set the value.
		Singleton x = Singleton.INSTANCE;
		x.setValue(2);
		System.out.println("Value is  "+x.getValue());
		
		Singleton y = Singleton.INSTANCE;
		System.out.println("Value is "+y.getValue());
		
		//As per the documentation enums are inherently serializable
		System.out.println(x instanceof Serializable?"Yes":"No");
		
		}
}
