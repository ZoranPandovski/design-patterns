# Front Controller Design Pattern

In this pattern, there exists a single handler that is responsible for handling/accepting all the requests and then it forwards the requests to the appropriate handlers according to request type. The front controller may use other handlers to coordinate the dispatching of the requests.

## Components
There are 4 main components of this pattern:

* #### Controller:

  It is responsible for handling all the requests and passing it on to correct dispatcher. All the requests are made to the controller.

  Here `FrontController.java` file is the controller. As the controller is the main entry point for all the requests, it has an instance of the dispatcher.

  When a request is received, the `dispatchRequest()` method will authenticate the user and send the request to dispatcher to execute.

* #### View:

  Views are the components that display data to the user. A view takes the data from a model and displays it.

  Here `GoHome` and `GoTution` are the views are display the respective data.

* #### Dispatcher:

  A dispatcher is responsible for view management and navigation, managing the choice of the next view to present to the user.

  Here `Dispatcher.java` file is the dispatcher. It has a `dispatch()` method that takes the request and decides which view to display

* #### Helper:

  A helper is responsible for helping a view or controller complete its processing. Thus, helpers have numerous responsibilities, including gathering data required by the view and storing this intermediate model
