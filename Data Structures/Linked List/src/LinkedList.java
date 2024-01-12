public class LinkedList {

    // Node class representing an element in the linked list
    private Node head;  // points to the first node in the list
    private Node tail;  // points to the last node in the list
    private int length; // stores the number of nodes in the list

    // Inner class representing a node in the linked list
    class Node {
        int value;   // holds the data of the node
        Node next;   // reference to the next node in the list

        // Constructor to initialize a node with a given value
        Node(int value) {
            this.value = value;
        }
    }

    // Constructor to initialize a linked list with a single node
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // Getter method to retrieve the head of the linked list
    public Node getHead() {
        return head;
    }

    // Getter method to retrieve the tail of the linked list
    public Node getTail() {
        return tail;
    }

    // Getter method to retrieve the length of the linked list
    public int getLength() {
        return length;
    }

    // Method to print the entire linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    // Method to print information about the linked list (head, tail, length)
    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    // Method to empty the linked list by setting head, tail, and length to null/zero
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    // Method to append a new node with the given value to the end of the linked list
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            // If the list is empty, set both head and tail to the new node
            head = newNode;
            tail = newNode;
        } else {
            // If the list is not empty, add the new node to the end and update the tail
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    // Method to remove and return the last node in the linked list
    public Node removeLast() {
        if (length == 0) return null; // If the list is empty, return null
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;        // Update tail to the previous node
        tail.next = null;  // Remove the reference to the last node
        length--;
        if (length == 0) {
            // If the list becomes empty, update head and tail to null
            head = null;
            tail = null;
        }
        return temp;  // Return the removed node
    }

    // Method to prepend a new node with the given value to the beginning of the linked list
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            // If the list is empty, set both head and tail to the new node
            head = newNode;
            tail = newNode;
        } else {
            // If the list is not empty, add the new node to the beginning and update the head
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    // Method to remove and return the first node in the linked list
    public Node removeFirst() {
        if (length == 0) return null; // If the list is empty, return null
        Node temp = head;
        head = head.next;  // Update head to the next node
        temp.next = null;  // Remove the reference to the first node
        length--;
        if (length == 0) {
            // If the list becomes empty, update tail to null
            tail = null;
        }
        return temp;  // Return the removed node
    }

    // Method to get the node at a specific index in the linked list
    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Method to set the value of the node at a specific index in the linked list
    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    // Method to insert a new node with the given value at a specific index in the linked list
    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            // If inserting at the beginning, use the prepend method
            prepend(value);
            return true;
        }
        if (index == length) {
            // If inserting at the end, use the append method
            append(value);
            return true;
        }
        // Inserting at a specific index involves updating references
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    // Method to remove and return the node at a specific index in the linked list
    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        // Removing at a specific index involves updating references
        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    // Method to reverse the linked list
    public void reverse() {
        // Swap head and tail
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = null;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
}
