/*
	Method-Chaining in D work as any other language.
	The trick is to return the object that you are changing so you can call a method on itself again:
	(see example-1 )
*/

//example-1
struct Player
{
	string name;
	string _class;
	int age;
	int hit_points;

	ref Player setName( string name )
	{
		this.name = name;
		return this;
	}

	ref Player setAge( int age )
	{
		this.age = age;
		return this;
	}
}

/*
	But D have a feature called UFCS( universal function call syntax ) that allow
	a function to be called as method of an object by passing it as the first argument of the function:
	Example:
		void add(int a, int b);
		10.add(20); //is equivalent of add(10,20)
	This allow the creation of new behaviors for the object without having to add new methods on it
	(see example-2)
*/

//example-2

ref Player setClass( ref Player player, string _class )
{
	player._class = _class;
	return player;
}

ref Player setHitPoints( ref Player player, int hit_points )
{
	player.hit_points = hit_points;
	return player;
}


void main()
{
	//example-1
	auto player = Player().setName("Player Name").setAge(30);

	//example-2
	player.setClass("Warrior").setHitPoints(200);

	import std.stdio;
	writeln(player); 
}