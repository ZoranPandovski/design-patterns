This is a very simple concurrent server that creates a new server thread for every client that makes a request.
It has a very simple protocol: The client says "Hello", then sends an int that wants to be operated (in this case it subtracts
one from the given number). Finally, the client says "Goodbye", which ends the execution of both the client and server thread
instances.

To try it out, in first place run the MainServer.java file. Then, run as many Clients as you want, and send requests to the
server form their consoles.

This pattern is actually used by low load web servers, meaning that there aren't many requests, these requests are short
and they don't have a high processor usage.