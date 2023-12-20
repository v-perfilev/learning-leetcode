package problems.t1226;

class DiningPhilosophers {
    private final boolean[] forkIsBusy = new boolean[5];

    public DiningPhilosophers() {
    }

    // call the run() method of any runnable to execute its code
    public synchronized void wantsToEat(int philosopher,
                                        Runnable pickLeftFork,
                                        Runnable pickRightFork,
                                        Runnable eat,
                                        Runnable putLeftFork,
                                        Runnable putRightFork) throws InterruptedException {
        int lf = getLeftFork(philosopher);
        int rf = getRightFork(philosopher);
        while (forkIsBusy[lf] || forkIsBusy[rf]) {
            wait();
        }
        forkIsBusy[lf] = true;
        forkIsBusy[rf] = true;
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        forkIsBusy[lf] = false;
        forkIsBusy[rf] = false;
        notifyAll();
    }

    private int getLeftFork(int philosopher) {
        return philosopher;
    }

    private int getRightFork(int philosopher) {
        return (philosopher + 1) % 5;
    }

}
