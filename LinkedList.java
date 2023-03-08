/**
 * LinkedList.java
 * Author : Khant Zaw Hein
 * Date : 2023-02-25
 */

public class LinkedList<E> {
    private Node<E> head, tail;

    int length = 0;

    public void insert(E item) {
        Node<E> node = new Node<E>(item);

        if (this.tail != null) {
            this.tail.setNext(node);
        }

        // if list is empty mark the new node as both head and tail
        if (length == 0) {
            this.head = this.tail = node;
        }

        this.tail = node;
        length++;
    }

    public Node<E> delete(int index) {
        Node<E> current = this.head;

        if (index >= length) {
            throw new IllegalArgumentException("Index is greater than length of the array list");
        }

        for (int i = 1; i < index; i++) {
            // get the item before the index (index - 1)
            current = current.getNext();
        }

        Node<E> tmp;

        if (index == 0) {
            tmp = this.head;
            this.head = current.getNext();
        } else {
            // This is item to be deleted.
            tmp = current.getNext();
            current.setNext(tmp.getNext());
            // If deleting the tail, change the tail
            if (index == length - 1) {
                tail = current;
            }
        }

        length--;

        return tmp;
    }

    public void deleteAll() {
        this.head = this.tail = null;
        this.length = 0;
    }

    public int getSize() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    // Print all items
    public void traversal() {
        Node<E> current = this.head;
        if (length == 0) {
            System.out.println("Nothing to show, empty linked list.");
        }

        for (int i = 0; i < length; i++) {
            System.out.println(current.getItem());
            current = current.getNext();
        }
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }
}