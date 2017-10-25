import java.util.concurrent.Callable;

public class AOBookingDemo {
    static class BookingServant extends ActiveObject<Integer> {
        private int totalTicket;

        public BookingServant(int aTotalTicket) {
            totalTicket = aTotalTicket;
        }

        public int buyTicket(int numberTicket) {

            // simulate processing time
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (numberTicket > totalTicket) {
                return 0;
            } else {
                totalTicket -= numberTicket;
                return numberTicket;
            }
        }

        public int remainTicket() {
            return totalTicket;
        }
    }

    static class BookingProxy {
        private final BookingServant scheduler;

        public BookingProxy(BookingServant aScheduler) {
            this.scheduler = aScheduler;
        }

        public ActiveObject.Callback<Integer> buyTicket(int numberTicket) throws InterruptedException {
            return scheduler.enqueue(new Callable<Integer>() {
                @Override
                public Integer call() {
                    return scheduler.buyTicket(numberTicket);
                }
            });
        }
    }

    static class BookingClient extends Thread {
        private final BookingProxy proxy;
        private final String name;

        public BookingClient(String name, BookingServant scheduler) {
            this.proxy = new BookingProxy(scheduler);
            this.name = name;
        }

        @Override
        public void run() {
            int numTicket = (int) (Math.random() * 200);

            try {
                ActiveObject.Callback<Integer> re = proxy.buyTicket(numTicket);
                System.out.println("Client " + name + " set buy command: " + numTicket + " ticket(s)");

                while (!re.isDone()) ;

                if (re.isSuccess()) {
                    System.out.println("Client " + name + " bought: " + re.getRes() + " ticket(s)");
                } else {
                    System.out.println("Client " + name + " bought fail");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BookingServant bookingServant = new BookingServant(400);

        BookingClient client1 = new BookingClient("C1", bookingServant);
        BookingClient client2 = new BookingClient("C2", bookingServant);
        BookingClient client3 = new BookingClient("C3", bookingServant);
        BookingClient client4 = new BookingClient("C4", bookingServant);
        BookingClient client5 = new BookingClient("C5", bookingServant);

        client1.start();
        client2.start();
        client3.start();
        client4.start();
        client5.start();

        client1.join();
        client2.join();
        client3.join();
        client4.join();
        client5.join();

        System.out.println("Remain: " + bookingServant.remainTicket());

    }
}
