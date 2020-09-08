package com.wt.test.leetcode.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 1114. 按序打印
 * https://leetcode-cn.com/problems/print-in-order/
 *
 * @author 一贫
 * @date 2020/9/8
 */
public class Problem1114 {

    public static void main(String[] args) {

    }


    //CountDownLatch实现
    class Foo2 {

        private volatile CountDownLatch cdl2 = new CountDownLatch(1);
        private volatile CountDownLatch cdl3 = new CountDownLatch(1);


        public Foo2() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            cdl2.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            cdl2.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            cdl3.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            cdl3.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    //标志位实现
    static class Foo1 {

        private volatile int flag = 1;

        public Foo1() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag = 1;
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            while (flag != 2) {
                Thread.sleep(0L);
            }
            printSecond.run();
            flag = 3;
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            while (flag != 3) {
                Thread.sleep(0L);
            }
            printThird.run();
        }
    }
}
