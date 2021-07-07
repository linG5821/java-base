package com.ling5821.javabase.juc;

import java.util.concurrent.*;

/**
 * @author lsj
 * @date 2021/7/7 16:26
 */
public class CyclicBarrierExample {
    /* 用来控制多个线程互相等待，只有当多个线程都到达时，这些线程才会继续执行 */
    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            int finalI = i;
            executorService.execute(() -> {
                if (finalI == totalThread - 1) {
                    System.out.println("before..");
                } else {
                    System.out.print("before..");
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.print("after..");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println();
        executorService.shutdown();


    }
}
