
//Given the array nums after the possible rotation and an integer target,
// return the index of target if it is in nums, or -1 if it is not in nums.
class SearchRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        return binarySearch(nums, target, 0, nums.size - 1)
    }
    private fun binarySearch(nums: IntArray, target: Int, left: Int, right: Int): Int {
        if (left > right) return -1
        val mid = left + (right - left) / 2
        if (nums[mid] == target) return mid
        return if (nums[left] <= nums[mid]) {
            if (target >= nums[left] && target < nums[mid]) {
                binarySearch(nums, target, left, mid - 1)
            } else {
                binarySearch(nums, target, mid + 1, right)
            }
        } else {
            if (target > nums[mid] && target <= nums[right]) {
                binarySearch(nums, target, mid + 1, right)
            } else {
                binarySearch(nums, target, left, mid - 1)
            }
        }
    }
}
fun main() {
    val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val target = 0
    val solution = SearchRotatedSortedArray()
    println(solution.search(nums, target))
}


