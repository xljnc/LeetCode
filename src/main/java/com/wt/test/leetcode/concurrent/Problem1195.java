package com.wt.test.leetcode.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 1195. 交替打印字符串
 * https://leetcode-cn.com/problems/fizz-buzz-multithreaded/
 * <p>
 * 使用Lock配合4个Condition来唤醒对应的打印线程。
 * curr表示当前值，从1开始。
 * 线程循环开始后，需要判断是否符合执行条件。如果否，则等待。
 * 如果是，则打印，然后curr++，然后唤醒对应符合条件的线程，如果curr>n,则唤醒所有线程，避免无限等待。
 * 线程被唤醒，先要判断curr>n,如果是，唤醒其他线程， 自身退出。
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

    private ReentrantLock lock = new ReentrantLock();
    private Condition fizzC = lock.newCondition();
    private Condition buzzC = lock.newCondition();
    private Condition fizzbuzzC = lock.newCondition();
    private Condition numberC = lock.newCondition();

    public static void main(String[] args) throws Exception {
        Problem1195 problem1195 = new Problem1195(15);
        new Thread(() -> {
            try {
                problem1195.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "fizz").start();

        new Thread(() -> {
            try {
                problem1195.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "buzz").start();

        new Thread(() -> {
            try {
                problem1195.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "fizzbuzz").start();

        new Thread(() -> {
            try {
                problem1195.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "number").start();

    }

    // printFizz.run() outputs "fizz".
    public void fizz() throws InterruptedException {
        while (curr <= n) {
            try {
                lock.lock();
                if (curr % 3 != 0 || curr % 5 == 0)
                    fizzC.await();
                if (curr > n) {
                    buzzC.signal();
                    fizzbuzzC.signal();
                    numberC.signal();
                    return;
                }
                System.out.println("fizz");
                curr++;
                call(curr);
            } finally {
                lock.unlock();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz() throws InterruptedException {
        while (curr <= n) {
            try {
                lock.lock();
                if (curr % 5 != 0 || curr % 3 == 0)
                    buzzC.await();
                if (curr > n) {
                    fizzC.signal();
                    fizzbuzzC.signal();
                    numberC.signal();
                    return;
                }
                System.out.println("buzz");
                curr++;
                call(curr);
            } finally {
                lock.unlock();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz() throws InterruptedException {
        while (curr <= n) {
            try {
                lock.lock();
                if (curr % 15 != 0)
                    fizzbuzzC.await();
                if (curr > n) {
                    fizzC.signal();
                    buzzC.signal();
                    numberC.signal();
                    return;
                }
                System.out.println("fizzbuzz");
                curr++;
                call(curr);
            } finally {
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number() throws InterruptedException {
        while (curr <= n) {
            try {
                lock.lock();
                if (curr % 3 == 0 || curr % 5 == 0)
                    numberC.await();
                if (curr > n) {
                    fizzC.signal();
                    buzzC.signal();
                    fizzbuzzC.signal();
                    return;
                }
                System.out.println(curr);
                curr++;
                call(curr);
            } finally {
                lock.unlock();
            }
        }

    }

    private void callAll() {
        fizzC.signalAll();
        buzzC.signalAll();
        fizzbuzzC.signalAll();
        numberC.signalAll();
    }

    private void call(int curr) throws InterruptedException {
        if (curr > n) {
            fizzC.signalAll();
            buzzC.signalAll();
            fizzbuzzC.signalAll();
            numberC.signalAll();
        } else if (curr % 3 == 0 && curr % 5 != 0)
            fizzC.signal();
        else if (curr % 5 == 0 && curr % 3 != 0)
            buzzC.signal();
        else if (curr % 15 == 0)
            fizzbuzzC.signal();
        else
            numberC.signal();
    }


}


class Resolution1 {

    private int n;

    private volatile int curr = 1;

    public Resolution1(int n) {
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