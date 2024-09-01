package LinkedList.Implementation;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    /* Node class */
    public static class Node {
        public int value;
        public Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList() {
        Node rootNode = null;
    }

    public LinkedList(int value) {
        Node rootNode = new Node(value);
        head = rootNode;
        tail = rootNode;
        length = 1;
    }

    /* Getters for attributes */
    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    /* Custom methods */
    public String printList(Node head) {
        Node temp = head;
        StringBuilder returnString = new StringBuilder();
        while (temp != null) {
            returnString.append(temp.value);
            temp = temp.next;
            if (temp != null)
                returnString.append(" -> ");
        }
        return returnString.append(" -> null ").toString();
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0)
            head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0)
            head = tail = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node get(int index) {
        if (index < 0 || index >= length)
            return null;
        Node temp = head;
        int counter = 0;
        while (counter != index) {
            temp = temp.next;
            counter++;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        Node newNode = new Node(value);
        if (length == 0)
            head = tail = newNode;
        else {
            if (index < 0 || index > length)
                return false;
            else if (index == 0) {
                prepend(value);
                return true;
            } else if (index == length) {
                append(value);
                return true;
            } else {
                Node temp = get(index - 1);
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
        length++;
        return true;
    }

    public Node removeLast() {
        Node secondLastNode = get(length - 2);
        Node lastNode = tail;
        tail = secondLastNode;
        secondLastNode.next = null;
        tail.next = null;
        length--;
        return lastNode;
    }

    public Node removeStart() {
        Node firstNode = head;
        head = head.next;
        firstNode.next = null;
        length--;
        return firstNode;
    }

    public Node remove(int index) {
        Node removedNode;
        if (index < 0 || index >= length)
            return null;
        else if (index == 0)
            removedNode = removeStart();
        else if (index == length - 1)
            removedNode = removeLast();
        else {
            Node previousNode = get(index - 1);
            Node currentNode = get(index);
            previousNode.next = currentNode.next;
            currentNode.next = null;
            length--;
            return currentNode;
        }
        return removedNode;
    }

    public void reverse() {
        LinkedList newRoot = new LinkedList();
        Node current = this.head;
        while(current != null) {
            newRoot.prepend(current.value);
            current = current.next;
        }
        this.head = newRoot.getHead();
        this.tail = newRoot.getTail();
    }
}