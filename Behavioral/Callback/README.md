# Callback

Callbacks are a way to pass a set of statements to execute as an argument to other code. This can be done in many fashions, most familiar are so-called callback functions. They, for instance, do take a function pointer. The function receiving this function pointer can then decide when to execute the function and do the **_callback_**.
There are two main ways to realise a callback, the first one is a _synchronous_ callback which simply blocks the current data flow by being executed, hence the name. An _asynchronous_ callback is a bit more complicated and may be thought of like a function that is registered somewhere and invoked wherever it's necessary. Imagine a game that uses callbacks for its mouse clicks. A certain callback may be triggered when a click happens and is then handled with the callback.

![callback visualization](https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Callback-notitle.svg/1024px-Callback-notitle.svg.png)