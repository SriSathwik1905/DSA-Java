public class Main {
    public static void main(String[] args) {
        // Create a new linked list with an initial value of 4
        LinkedList myLinkedList = new LinkedList(4);

        // Append values to the linked list
        myLinkedList.append(5);
        myLinkedList.append(6);
        myLinkedList.append(7);
        myLinkedList.prepend(8);

        // Prepend a value to the linked list
        myLinkedList.prepend(3);

        // Print the linked list
        System.out.println("Linked List:");
        myLinkedList.printList();

        // Get and print the value at index 2
        int indexToRetrieve = 2;
        System.out.println("\nValue at index " + indexToRetrieve + ": " + myLinkedList.get(indexToRetrieve).value);
    }
}
