package 多线程打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WJL
 * @date: 2021/08/04 17:00
 **/

public class ConditionPrint {


    public static void main(String[] args) {
        new ConditionA().start();
        new ConditionB().start();
    }

    private static ReentrantLock lock = new ReentrantLock();
    private static int count = 1;

    static Condition CA = lock.newCondition();
    static Condition CB = lock.newCondition();


    static class ConditionA extends Thread{
        @Override
        public void run() {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                while (count % 2 != 1){
                    try {
                        CA.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("A");
                count++;
                CB.signal();
            }
            lock.unlock();
        }
    }

    static class ConditionB extends Thread{
        @Override
        public void run() {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                while (count % 2 != 0){
                    try {
                        CB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B");
                count++;
                CA.signal();
            }
            lock.unlock();
        }
    }
}