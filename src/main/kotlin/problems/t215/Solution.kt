package problems.t215

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val size = nums.size
        for (i in size / 2 - 1 downTo 0) {
            heapify(nums, size, i)
        }
        for (i in size - 1 downTo 1) {
            swap(nums, 0, i)
            heapify(nums, i, 0)
        }
        return nums[k - 1]
    }

    private fun heapify(arr: IntArray, n: Int, i: Int) {
        var largest = i
        val l = 2 * i + 1
        val r = 2 * i + 2

        if (l < n && arr[l] < arr[largest]) {
            largest = l
        }

        if (r < n && arr[r] < arr[largest]) {
            largest = r
        }

        if (largest != i) {
            swap(arr, i, largest)
            heapify(arr, n, largest)
        }
    }

    private fun swap(arr: IntArray, a: Int, b: Int) {
        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }
}
