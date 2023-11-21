package problems.t1845

import java.util.PriorityQueue

class SeatManager(n: Int) : PriorityQueue<Int>() {
    private var reservedCount = 0

    fun reserve(): Int {
        this.reservedCount++
        return poll() ?: this.reservedCount
    }

    fun unreserve(seatNumber: Int) {
        if (seatNumber != this.reservedCount + super.size) offer(seatNumber)
        this.reservedCount--
    }
}
