package com.wt.test.leetcode.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 1117. H2O 生成
 * https://leetcode-cn.com/problems/building-h2o/
 *
 * @author 一贫
 * @date 2020/9/10
 */
public class Problem1117 {


    private Semaphore hydrogen = new Semaphore(2);

    private Semaphore oxygen = new Semaphore(0);
    ;

    public Problem1117() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        hydrogen.acquire(1);
        releaseHydrogen.run();
        oxygen.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        oxygen.acquire(2);
        releaseOxygen.run();
        hydrogen.release(2);
    }

}
