# Note on the differences between the Observer and Publish/Suscribe Pattern

Although the Observer pattern is very useful, one will most often find the Publish/Suscribe varation used in JavaScript.

The Observer pattern requires that the observer object explicitly subscribe to the object firing the event (the Subject). 

![UML of Publish/Subscribe Pattern](https://i.gyazo.com/f87c0918bce7572cba05c0c8b7b992a3.png)

The Publish/Suscribe pattern modifies this requirement by making use of a topic/event channel that sits in between the subscribers and the object firing the event (the publisher). This event based system allows the application to define specfic events that contain values needed by the subscriber. Ideally, this pattern helps to avoid dependencies between the subscriber and publisher.

This pattern differs from the Observer pattern in that it allows any subscriber that implements the appropriate event handler to register and receive event specific notifications from the publisher.