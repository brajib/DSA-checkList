
//find the length of the longest substring without duplicate characters.
fun main(){
    val solution = LongestSubstring()
    val input = "abcabcbb"
    println(solution.longestSubStr(input))
}
class LongestSubstring(){
    fun longestSubStr(s: String): Int{
        val charSet = HashSet<Char>()
        var maxLen = 0
        var left = 0
        for (right in s.indices) {
            while (charSet.contains(s[right])) {
                charSet.remove(s[left])
                left++
            }
            charSet.add(s[right])
            maxLen = maxOf(maxLen, right - left + 1)
        }
        return maxLen
    }
    }