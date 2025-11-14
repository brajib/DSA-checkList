//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
//such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0
fun main(){
    val solution = threeSum()
    val input = intArrayOf(-1, 0, 1, 2, -1, -4)
    val result = solution.threeSumSolution(input)
    println(result)
}
class threeSum(){
    fun threeSumSolution(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
        nums.sort()
        val res = mutableSetOf<List<Int>>()
        for (i in 0 until nums.size - 2) {
            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                when {
                    sum == 0 -> {
                        res.add(listOf(nums[i], nums[left], nums[right]))
                        left++
                        right--
                    }
                    sum < 0 -> left++
                    else -> right--
                }
            }
        }
        return res.toList()
    }
}