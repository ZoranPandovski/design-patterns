# The Adapter pattern in Ruby

This example implements the adapter pattern to adapt male-dominated tech world to
be more open towards ladies among us.

The general stereotype is that programmers are guys, so addressing a random programmer
is often done in the male-form, possibly offending the girls.

Classes defined in this example:

* `Person` a natural person with a name
* `Guy` and `Gal` are subclasses of `Person`
* `StereotypicProgrammer` expects unfortunately that it's person is a guy, so it outputs Bio using `"His skills are:"` prefix
* `RespectfulProgrammerAdapter` is an adapter to above stereotype to fixing the output of bio if programmer is a `Gal`.
* `SoftwareBook` is an example use for the above classes, setting up a list of people and printing their bios.

Example output:

```
      Dennis
      His skills are:
      	- C
      	- UNIX

      Mark
      His skills are:
      	- PHP
      	- SocialNetwork

      Ada
      Her skills are:
        - Math
        - Analytics
  ```
