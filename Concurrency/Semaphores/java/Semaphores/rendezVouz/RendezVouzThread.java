package Semaphores.rendezVouz;

public class RendezVouzThread extends Thread {

    private int type;

    public final static int TYPE_A = 1;

    public final static int TYPE_B = 0;

    public RendezVouzThread(int type ) {
        this.type = type;
    }


    @Override
    public void run() {
        /*
         * xA() and xB() can be called in any order, so each threads calls the one it corresponds to them first. Then,
         * one of the thread calls release() on one of the semaphores, so when the other one calls acquire() it doesn't
         * block. Then, the first thread calls acquire() on the other semaphore to wait for the other thread. Finally,
         * the second thread calls release() on the semaphore that the firs thread is blocked. This way, yB() is always
         * called before yA(). Independently of the order that the threads started
         */
        if(type == TYPE_A){
            RendezVouz.xA();
            RendezVouz.s1.release();
            RendezVouz.s2.acquire();
            RendezVouz.yA();
        }
        else if(type == TYPE_B){
            RendezVouz.xB();
            RendezVouz.s1.acquire();
            RendezVouz.yB();
            RendezVouz.s2.release();
        }
    }

}
