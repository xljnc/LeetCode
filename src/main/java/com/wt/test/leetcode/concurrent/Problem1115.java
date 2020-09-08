package com.wt.test.leetcode.concurrent;

/**
 * 1115. 交替打印FooBar
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 *
 * @author 一贫
 * @date 2020/9/8
 */
public class Problem1115 {

    class FooBar {
        private int n;

        private volatile boolean flag = true;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                while (!flag) {
                    Thread.sleep(0L);
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = false;
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (flag) {
                    Thread.sleep(0L);
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = true;

            }
        }
    }
}
