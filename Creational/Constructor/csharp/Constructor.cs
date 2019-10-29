using System;

class User
{   
  private String name;
  private int age;
	
	public string Details 
    { 
        get
        { 
            return "Name: " + name.ToString() +  
                     "\nAge: " + age.ToString() + "\n"; 
        } 
    } 
	
  // Default Constructor
  public User() 
  {
	   Console.WriteLine("Default Constructor Called \n"); 
  }
	
 // Parameterised Constructor
  public User(string Name, int Age)
  {
	  name = Name;
	  age = Age;
	  Console.WriteLine("Parameterised Constructor Called"); 
	  Console.WriteLine("User "+name+" "+ "is of age "+age+"\n"); 
  }

  // Copy Constructor
  public User(User s) 
  { 
      name = s.name; 
      age = s.age;
	  Console.WriteLine("Copy Constructor Called"); 
  } 
	
	// Static constructor
	static User() 
    { 
		// The following statement produces 
        // the first line of output, 
        // and the line occurs only once. 
        Console.WriteLine("Static Constructor\n"); 

    } 
	
}

					
public class Program
{
	public static void Main()
	{
		//default constructor called
		User user1 = new User(); 
		
		//parameterised constructor called
		User user2 = new User("Andrew",20); 
		
		//copy constructor called
		User user3 = new User(user2); 
		Console.WriteLine(user3.Details); 
		
	}
}

