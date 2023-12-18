package problems.t1114;

import java.util.concurrent.Semaphore;

class Foo {
    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(1);

    public Foo() {
        try {
            s1.acquire();
            s2.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s1.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}
