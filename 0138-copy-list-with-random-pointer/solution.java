/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp2 = head;
        Node temp = null;
        Map<Node, Node> map = new HashMap<>();
        Node currHead = null;

        while (head != null) {
            System.out.println(head.val);
            if (currHead == null) {
                temp = new Node(head.val);
                currHead = temp;
                map.put(head, temp);
                head = head.next;
            } else {
                temp.next = new Node(head.val);
                map.put(head, temp.next);
                head = head.next;
                temp = temp.next;
            }
        }

        Node head2 = currHead;

        while(head2 != null){
            //System.out.println('1');
            head2.random = map.get(temp2.random);
            temp2 = temp2.next;
            head2 = head2.next;
        }

        return currHead;
    }
}
