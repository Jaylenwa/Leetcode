package 多线程打印;

import java.util.concurrent.Semaphore;

/**
 * @author WJL
 * @date: 2021/08/04 16:58
 * 信号量打印
 **/

public class SemaphorePrint {

    public static void main(String[] args) {
        new SemaphoreA().start();
        new SemaphoreB().start();
    }


    static Semaphore A = new Semaphore(1);
    static Semaphore B = new Semaphore(0);

    static class SemaphoreA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    A.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A");
                B.release();
            }
        }
    }

    static class SemaphoreB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    B.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");
                A.release();
            }
        }
    }


}