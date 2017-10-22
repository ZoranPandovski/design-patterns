# Command Pattern in C#

The sample console app project is written on .NET Core 1.1. You should have [.NET Core SDK](https://www.microsoft.com/net/targeting?utm_source=getdotnetsdk&utm_medium=referral) to build and run it.

After installation of .NET Core Runtime run this command to restore packages on the project folder;

> ..\design-patterns\Behavioral\Command\C#>dotnet restore

There is not any dependency but this command prepares the project for building. Now run build command to generate our .dll file.

> ..\design-patterns\Behavioral\Command\C#>dotnet build

Now you could run the console app but remember to provide arguments;

> ..\design-patterns\Behavioral\Command\C#>dotnet run ON

or

> ..\design-patterns\Behavioral\Command\C#>dotnet run OFF

Consider a "simple" switch. In this example we configure the Switch with two commands: to turn the light on and to turn the light off.

A benefit of this particular implementation of the command pattern is that the switch can be used with any device, not just a light. The Switch in the following C# implementation turns a light on and off, but the Switch's constructor is able to accept any subclasses of Command for its two parameters. For example, you could configure the Switch to start an engine.