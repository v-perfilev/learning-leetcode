package problems.t1279;

import java.util.concurrent.locks.ReentrantLock;

public class TrafficLight {

    private final ReentrantLock lock = new ReentrantLock(false);
    private volatile int roadId = 1;


    public TrafficLight() {
    }

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) {
        lock.lock();
        try {
            if (this.roadId != roadId) {
                turnGreen.run();
                this.roadId = roadId;
            }
            crossCar.run();
        } finally {
            lock.unlock();
        }
    }

}
