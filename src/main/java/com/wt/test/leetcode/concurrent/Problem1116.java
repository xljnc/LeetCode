package com.wt.test.leetcode.concurrent;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 1116. 打印零与奇偶数
 * https://leetcode-cn.com/problems/print-zero-even-odd/
 *
 * @author 一贫
 * @date 2020/9/10
 */
public class Problem1116 {
    private int n;

    private Semaphore zero = new Semaphore(1);
    private Semaphore odd = new Semaphore(0);
    private Semaphore even = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zero.acquire(1);
            printNumber.accept(0);
            if (i % 2 == 1)
                odd.release(1);
            else
                even.release(1);
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even.acquire(1);
            printNumber.accept(i);
            zero.release(1);
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            odd.acquire(1);
            printNumber.accept(i);
            zero.release(1);
        }
    }
}
