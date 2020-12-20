package edu.practice.java.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * a linear data structure containing interconnected nodes through pointers
 * Since there is no concept of pointers in Java, each node holds the reference of another node
 * but the last element of the linked list refers to NULL, meaning the end of the list.
 * [head] -> [] -> [] -> [] -> [] -> null
 * [head] -> [] -> [current node] -> [] -> [] -> null
 * A linked list is memory efficient but takes some extra memory for pointers that points to the next node.
 * reverse [previous] <- [current] <- [next]
 * @param <T>
 */
public class CustomLinkedList<T> {

    Node<T> head;

    public void insert(T data) {
        if (data == null) {
            throw new NullPointerException();
        }
        Node<T> nodeToBeInserted = new Node<>(data);

        if (this.head == null) {
            this.head = nodeToBeInserted;
        } else {
            Node<T> currentNode = this.head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(nodeToBeInserted);
        }
    }

    public void insertAt(int index, T data) {
        Node<T> nodeToBeInserted = new Node<>(data);
        Node<T> currentNode = this.head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.getNext();
        }
        nodeToBeInserted.setNext(currentNode.getNext());
        currentNode.setNext(nodeToBeInserted);
    }

    public void deleteNodeAt(int index) {
        Node<T> currentNode = this.head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(currentNode.getNext().getNext());
    }

    public void reverse() {
        Node<T> previous = null;
        Node<T> current = this.head;
        Node<T> next;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        this.head = previous;
    }

    public boolean checkLoop(){
        boolean loopExists = false;
        Map<Node<T>, Integer> map = new HashMap<>();
        Node<T> tempNode = this.head;
        while (tempNode != null){
            if(map.get(tempNode) == null){
                map.put(tempNode, 1);
            }else {
                map.put(tempNode, 2);
                loopExists = true;
                break;
            }
            tempNode = tempNode.getNext();
        }
        return loopExists;
    }

    public void display() {
        if (this.head != null) {
            Node<T> currentNode = this.head;
            while (currentNode.getNext() != null) {
                System.out.print("[" + currentNode.getData() + "]->");
                currentNode = currentNode.getNext();
            }
            System.out.println("[" + currentNode.getData() + "]" );
        }
    }
}
