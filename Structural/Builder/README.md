Builder pattern simplifies object creation in very clean and readable way. It’s very helpful when we have some model classes with many parameters. 
We can make some of them optional or required, and we don’t force the user to use specific order (as in the constructor). By using Builder pattern we result with the elegant chain of the methods. 

The most common use is in AlertDialog.Builder() class:

```
new AlertDialog.Builder(this)
        .setTitle("Design Patterns")
        .setMessage("Builder is awesome")
        .create();
```

##Builder — protip
If you were patient enough to get through the whole blog post, 
I have one tip for you regarding Builder pattern: you can generate the whole Builder class using **IntelliJ!**

All you need to do is place the caret on the constructor in your class and choose Refactor -> Replace Constructor with Builder on the context menu. 
Builder class with all the methods will be auto generated, ready for use.
