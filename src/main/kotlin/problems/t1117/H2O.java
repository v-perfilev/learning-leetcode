package problems.t1117;

import java.util.concurrent.Semaphore;

class H2O {
    private final Semaphore oxygenSemaphore = new Semaphore(2);
    private final Semaphore hydrogenSemaphore = new Semaphore(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();
        releaseHydrogen.run();
        oxygenSemaphore.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire(2);
        releaseOxygen.run();
        hydrogenSemaphore.release(2);
    }
}
