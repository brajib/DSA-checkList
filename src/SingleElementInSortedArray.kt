//You are given a sorted array consisting of only integers where every element appears exactly twice,
// except for one element which appears exactly once.
//Return the single element that appears only once.
//Your solution must run in O(log n) time and O(1) space.
class SingleElementInSortedArray {
    fun singleNonDuplicate(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            var mid = (left + right) / 2
            if (mid % 2 == 1) mid--

            if (nums[mid] != nums[mid + 1]) {
                right = mid
            } else {
                left = mid + 2
            }
        }
        return nums[left]
    }
}
fun main() {
    val solution = SingleElementInSortedArray()
    val nums = intArrayOf(1, 1, 2, 3, 3, 4, 4, 8, 8)
    println(solution.singleNonDuplicate(nums)) // Output: 2
}