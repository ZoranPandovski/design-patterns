#include <iostream>

using namespace std;

/*the Command interface*/
class Command 
{
public:
	virtual void execute()=0;
};

/*Receiver class*/
class Light {

public:
	Light() {  }

	void turnOn() 
	{
		cout << "The light is on" << endl;
	}

	void turnOff() 
	{
		cout << "The light is off" << endl;
	}
};

/*the Command for turning on the light*/
class FlipUpCommand: public Command 
{
public:

	FlipUpCommand(Light& light):theLight(light)
	{

	}

	virtual void execute()
	{
		theLight.turnOn();
	}

private:
	Light& theLight;
};

/*the Command for turning off the light*/
class FlipDownCommand: public Command
{
public:   
	FlipDownCommand(Light& light) :theLight(light)
	{

	}
	virtual void execute() 
	{
		theLight.turnOff();
	}
private:
	Light& theLight;
};

class Switch {
public:
	Switch(Command& flipUpCmd, Command& flipDownCmd)
	:flipUpCommand(flipUpCmd),flipDownCommand(flipDownCmd)
	{

	}

	void flipUp()
	{
		flipUpCommand.execute();
	}

	void flipDown()
	{
		flipDownCommand.execute();
	}

private:
	Command& flipUpCommand;
	Command& flipDownCommand;
};

 
/*The test class or client*/
int main() 
{
	Light lamp;
	FlipUpCommand switchUp(lamp);
	FlipDownCommand switchDown(lamp);

	Switch s(switchUp, switchDown);
	s.flipUp();
	s.flipDown();
}