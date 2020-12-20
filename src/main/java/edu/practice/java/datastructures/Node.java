package edu.practice.java.datastructures;

// create a generics class
public class Node<T> {

    // variable of T type
    private T data;
    private Node next; // connect each node to next node

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
