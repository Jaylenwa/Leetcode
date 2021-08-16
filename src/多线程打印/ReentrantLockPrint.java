package 多线程打印;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WJL
 * @date: 2021/08/04 16:59
 **/

public class ReentrantLockPrint {


    public static void main(String[] args) {

        new ThreadA().start();
        new ThreadB().start();
    }


    private static ReentrantLock lock = new ReentrantLock();

    private static int count = 1;


    static class ThreadA extends Thread {
        @Override
        public void run() {

            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (count % 2 == 1) {
                        System.out.println("A");
                        count++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (count % 2 == 0) {
                        System.out.println("B");
                        count++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}