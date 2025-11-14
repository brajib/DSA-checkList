//Given the head of a sorted linked list, delete all nodes that have duplicate numbers
// leaving only distinct numbers from the original list
// Return the linked list sorted as well
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
class RemoveDuplicatesFromLinkedList {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var prev: ListNode? = dummy
        var curr = head
        while (curr != null) {
            if (curr.next != null && curr.`val` == curr.next?.`val`) {
                while (curr?.next != null && curr.`val` == curr.next?.`val`) {
                    curr = curr.next
                }
                prev?.next = curr?.next
            } else {
                prev = prev?.next
            }
            curr = curr?.next
        }
        return dummy.next
    }
}
fun main() {
    val head = ListNode(1).apply {
        next = ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(3).apply {
                    next = ListNode(3)
                }
            }
        }
    }
    val solution = RemoveDuplicatesFromLinkedList()
    val result = solution.deleteDuplicates(head)
    var node = result
    while (node != null) {
        print("${node.`val`} ")
        node = node.next
    }
}
