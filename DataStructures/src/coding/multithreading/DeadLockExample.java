package coding.multithreading;

public class DeadLockExample {
    public static void main(String[] args) {

        String resource1 = "Resource1";
        String resource2 = "Resource2";

        Runnable r1 = () -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " locks " + resource1);
                /*
                Tries to get lock to resource2 on block.
                 */
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() +  " locks " + resource2);
                }
            }
        };

        Runnable r2 = () -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " locks " + resource2);
                /*
                        Tries to get lock to resource2 on block.
                 */

                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " locks " + resource1);
                }
            }
            /*
            Can solve this deadlock by releasing the lock on resource2 and then try to acquire the lock on resource1 in r2.
             */
        };

        Thread t1 = new Thread(r1);
        t1.setName("Thread 1");
        Thread t2 = new Thread(r2);
        t2.setName("Thread 2");
        t1.start();
        t2.start();
    }
}
