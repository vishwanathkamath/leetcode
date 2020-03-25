package leetcode;

class MyLinkedList {

    Node head;
    Node tail;
    int count;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        count = 0;
    }
    
    class Node {
        int val;
        Node next;
        Node prev;
        
        public Node(int val){
            this.val = val;
            next = null;
            prev = null;
        } 
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= count){
            return -1;
        }
        Node current = head.next;
        int indx = 0;
        while(indx < index){
            indx++;
            current = current.next;
        }
        return current.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        newNode.prev = head;
        newNode.next.prev = newNode;
        head.next = newNode;
        count++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        newNode.prev = tail.prev;
        newNode.next = tail;
        newNode.prev.next = newNode;
        tail.prev = newNode;
        count++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > count) {
            return;
        }
        if(index == 0) {
            addAtHead(val);
        }
        else if (index == count) {
            addAtTail(val);
        }
        else {
            int indx = 0;
            Node current = head;
            while(indx < index) {
                indx++;
                current = current.next;
            }
            Node newNode = new Node(val);
            newNode.prev = current;
            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;
            count++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index <0 || index>=count){
            return;
        }
        int indx = 0;
        Node current = head;
        while(indx < index) {
            indx++;
            current = current.next;
        }
        Node next = current.next.next;
        next.prev = current;
        current.next = next;
        count--;
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */