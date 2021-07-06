package com.ling5821.javabase.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author lsj
 * @date 2021/7/6 12:12
 */
public class UseThread {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        thread1.start();

        FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());
        Thread thread2 = new Thread(futureTask);
        thread2.start();

        MyThread thread3 = new MyThread();
        thread3.start();

    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("这是一个 基于 Runnable 实现");
        }
    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("这是一个 基于 Callable 实现");
            return 1;
        }
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("这是一个 基于 继承Thread 实现");
        }
    }
}
