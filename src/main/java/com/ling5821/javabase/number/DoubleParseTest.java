package com.ling5821.javabase.number;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.util.RandomUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author linG
 * @date 2023-08-31 21:54
 */
public class DoubleParseTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 8, 5, TimeUnit.MINUTES, new LinkedBlockingQueue<>());

        while (true) {
            for (int i = 0; i < 100; i++) {
                executor.execute(() -> {
                    execute();
                });
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public static List<Object> init() {
        int size = 1000;
        List<Object> values = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            values.add(RandomUtil.randomDouble(20000, 50000));
        }
        return values;
    }

    public static void execute() {
        List<Object> values = init();
        StopWatch stopWatch = new StopWatch("double-parse-test");
        stopWatch.start();
        for (int i = 0,size = values.size(); i < size; i++) {
            for (int j = 0; j < size; j++) {
                double v = Double.parseDouble(values.get(i).toString());
            }
        }
        stopWatch.stop();
        System.out.println(Thread.currentThread().getName() + " exec time " + stopWatch.getLastTaskTimeMillis() + " ms");
    }

}
