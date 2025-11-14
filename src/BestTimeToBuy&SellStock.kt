//Best Time to Buy and Sell Stock II
class BestTimeToBuyAndSellStock {
    fun buyAndSellStock(prices: IntArray): Int{
        var profit=0
        for (i in 1 until prices.size){
            if (prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1]
            }
        }
        return profit
    }
}
fun main() {
    val solution = BestTimeToBuyAndSellStock()
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    println(solution.buyAndSellStock(prices))
}