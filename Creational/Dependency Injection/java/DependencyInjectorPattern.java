/**
 * Contract for service implementations
 */
public interface MessageService {
    void sendMessage(String msg, String receiver);
}

/**
 * Consumer interface declaring contract for consumer classes
 */
public interface Consumer {
    void processMessages(String msg, String rec);
}

/**
 * An interface MessageServiceInjector with method declaration that returns the {@link Consumer} class.
 */
public interface MessageServiceInjector {
    public Consumer getConsumer();
}


/**
 * Email services that implement {@link MessageService}
 */
public class EmailServiceImpl implements MessageService {

    @Override
    public void sendMessage(String msg, String receiver) {
        System.out.println("Email sent to " + receiver + " with Message=" + msg);
    }

}

/**
 * Injector class for {@link EmailServiceImpl}
 */
public class EmailServiceInjector implements MessageServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new MyConsumer(new EmailServiceImpl());
    }
}


/**
 * SMS services that implement {@link MessageService}
 */
public class SMSServiceImpl implements MessageService {

    @Override
    public void sendMessage(String msg, String receiver) {
        System.out.println("SMS sent to " + receiver + " with Message=" + msg);
    }

}

/**
 * Injector class for {@link SMSServiceImpl}
 */
public class SMSServiceInjector implements MessageServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new MyConsumer(new SMSServiceImpl());
    }

}


/**
 * Implementation of {@link Consumer}. Notice that this class is just using the service. It does not initialize the service that leads to better “separation of concerns“.
 */
public class MyConsumer implements Consumer {

    private MessageService service;

    public MyConsumer(MessageService messageService) {
        this.service = messageService;
    }

    @Override
    public void processMessages(String msg, String receiver) {
        this.service.sendMessage(msg, receiver);
    }
}

/**
 * Client application
 */
public class MyApplication {

    public static void main(String[] args) {
        String msg = "This is injected ";
        String email = "riteshakya037@gmail.com";
        String phone = "+9779841814809";
        MessageServiceInjector injector = null;
        Consumer app = null;

        //Send email
        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, email);

        //Send SMS
        injector = new SMSServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, phone);
    }

}




