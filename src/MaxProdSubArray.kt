//find a subarray that has the largest product, and return the product.
fun main(){
    val solution = MaxProdSubArray()
    val nums = intArrayOf(2, 3, 0, -5,6,0,2)
    println(solution.maxProduct(nums))
}
class MaxProdSubArray(){
    fun maxProduct(nums: IntArray): Int {
        val n = nums.size
        var leftPrefix = 1
        var rightPrefix = 1
        var ans = nums[0]
        for (i in 0 until n) {
            if (leftPrefix == 0) leftPrefix = 1
            if (rightPrefix == 0) rightPrefix = 1
            leftPrefix *= nums[i]
            rightPrefix *= nums[n - 1 - i]
            ans = maxOf(ans, maxOf(leftPrefix, rightPrefix))
        }

        return ans
    }
}