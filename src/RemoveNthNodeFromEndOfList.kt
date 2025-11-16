class RemoveNthNodeFromEndOfList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var fast = head
        var slow = head
        repeat(n) { fast = fast?.next }
        if (fast == null) return head?.next
        while (fast?.next != null) {
            fast = fast.next
            slow = slow?.next
        }
        slow?.next = slow?.next?.next

        return head
    }
}
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
fun main() {
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }
    val solution = RemoveNthNodeFromEndOfList()
    val result = solution.removeNthFromEnd(head, 2)
    var node = result
    while (node != null) {
        print("${node.`val`} ")
        node = node.next
    }
}

