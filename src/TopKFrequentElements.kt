//Given an integer array nums and an integer k, return the k most frequent elements.
class TopKFrequentElements {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int, Int>()
        val buckets = Array<MutableList<Int>?>(nums.size + 1) { null }

        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }
        for ((key, freq) in map) {
            if (buckets[freq] == null) {
                buckets[freq] = mutableListOf()
            }
            buckets[freq]!!.add(key)
        }
        val result = IntArray(k)
        var count = 0

        for (i in buckets.indices.reversed()) {
            val bucket = buckets[i]
            if (bucket != null) {
                for (num in bucket) {
                    result[count++] = num
                    if (count == k) return result
                }
            }
        }
        return result
    }
}
fun main() {
    val solution = TopKFrequentElements()
    val nums = intArrayOf(1, 1, 1, 2, 2, 3)
    val k = 2
    val result = solution.topKFrequent(nums, k)
    println(result.joinToString())
}
