package com.ling5821.javabase.juc;

/**
 * @author lsj
 * @date 2021/7/6 14:35
 */
public class SynchronizedDemo {

    /* 同步代码块 锁对象 */
    public void setSynchronizedMethod() {
        synchronized (this) {
            // do something
        }
    }

    /* 同步代码块 锁类 */
    public void setSynchronizedStaticMethod() {
        synchronized (SynchronizedDemo.class) {
            // do something
        }
    }

    /* 同步方法 锁对象 */
    public synchronized void setSynchronizedStaticStaticMethod() {
        // do something
    }

    /* 同步静态方法  锁类 */
    public synchronized static void setSynchronizedStaticStaticMethod2() {
            // do something
    }


}
