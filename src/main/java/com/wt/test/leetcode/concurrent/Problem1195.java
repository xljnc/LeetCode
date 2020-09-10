package com.wt.test.leetcode.concurrent;

import java.util.function.IntConsumer;

/**
 * 1195. 交替打印字符串
 * https://leetcode-cn.com/problems/fizz-buzz-multithreaded/
 *
 * @author 一贫
 * @date 2020/9/10
 */
public class Problem1195 {

    private int n;

    private volatile int curr = 1;

    public Problem1195(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (curr <= n) {
            if (curr % 3 != 0 || curr % 5 == 0) {
                wait();
                continue;
            }
            printFizz.run();
            curr++;
            notifyAll();
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (curr <= n) {
            if (curr % 5 != 0 || curr % 3 == 0) {
                wait();
                continue;
            }
            printBuzz.run();
            curr++;
            notifyAll();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

        while (curr <= n) {

            if (curr % 15 != 0) {
                wait();
                continue;
            }
            printFizzBuzz.run();
            curr++;
            notifyAll();

        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {

        while (curr <= n) {

            if (curr % 3 == 0 || curr % 5 == 0) {
                wait();
                continue;
            }
            printNumber.accept(curr);
            curr++;
            notifyAll();
        }
    }
}
