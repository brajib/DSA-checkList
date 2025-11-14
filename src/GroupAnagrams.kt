//Given an array of strings strs, group the anagrams together. You can return the answer in any order
class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val charMap = HashMap<String, MutableList<String>>()

        for (s in strs) {
            val sorted = s.toCharArray().sorted().joinToString("") // Sort characters
            if (!charMap.containsKey(sorted)) {
                charMap[sorted] = mutableListOf()
            }
            charMap[sorted]!!.add(s)
        }

        return charMap.values.toList()
    }
}
fun main() {
    val solution = GroupAnagrams()
    val input = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val result = solution.groupAnagrams(input)
    println(result)
}

