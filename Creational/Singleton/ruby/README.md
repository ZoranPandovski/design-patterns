## Running the example

`ruby example.rb`

Viewing the contents of the created `log.txt` should show 'Hello World!' followed by 'Hello 
World! (on a different call)'

## Use of the pattern

When an object can and should only be instantiated once, like a Logger, the Singleton pattern 
makes a lot of sense. One object opens and writes to a file, rather than each method that 
wants to log having to open its own file. 

This pattern greatly simplifies the handling of globally available resources, but should not 
be used unless there is a specific reason for requiring only one instance of an object.
