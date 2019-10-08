interface CallbackHandler {
    void onCallback();
}

public class Main {
    public static void main(String[] args) {
        System.out.println("calling a function with callback defined");
        myFunction(new CallbackHandler() {
            @Override
            public void onCallback() {
                System.out.println("got callback");
            }
        });
    }

    static void myFunction(CallbackHandler callbackHandler) {
        // do something ...
        System.out.println("function called");

        // callback
        callbackHandler.onCallback();
    }
}
