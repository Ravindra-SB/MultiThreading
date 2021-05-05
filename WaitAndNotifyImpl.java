
public class WaitAndNotifyImpl {
    public static void main(String[] agrs) throws Exception {
        ChildThread childThread = new ChildThread();
        childThread.start();
        synchronized (childThread) {
            System.out.println("Main Thread Calling Wait() Method");
            childThread.wait();
            System.out.println("Main Thread Got Notification");
            System.out.println("Total: " + childThread.total);
        }
        System.out.println("End");
    }
}

class ChildThread extends Thread {
    int total = 0;

    public void run() {
        synchronized (this) {
            System.out.println("Child Thread starts Calculation");
            for (int i = 0; i < 10; i++) {
                total = total + i;
            }
            System.out.println("Child Thread Send Notification");
            this.notify();
        }

    }
}
