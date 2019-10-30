#include <iostream>

class Computer
{
public:
	virtual void Run() = 0;
	virtual void Stop() = 0;

	virtual ~Computer() {}; /* without this, you do not call Laptop or Desktop destructor in this example! */
};

class Laptop : public Computer
{
public:
	void Run() override { mHibernating = false; };
	void Stop() override { mHibernating = true; };
	virtual ~Laptop() {}; /* because we have virtual functions, we need virtual destructor */
private:
	bool mHibernating; // Whether or not the machine is hibernating
};

class Desktop : public Computer
{
public:
	void Run() override { mOn = true; };
	void Stop() override { mOn = false; };
	virtual ~Desktop() {};
private:
	bool mOn; // Whether or not the machine has been turned on
};

class ComputerFactory
{
public:
	static Computer* NewComputer(const std::string& description)
	{
		if (description == "laptop")
			return new Laptop;
		if (description == "desktop")
			return new Desktop;
		return nullptr;
	}
};