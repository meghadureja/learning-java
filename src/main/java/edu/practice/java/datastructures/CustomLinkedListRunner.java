package edu.practice.java.datastructures;

public class CustomLinkedListRunner {
    public static void main(String[] args) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.insert(5);
        customLinkedList.insert(10);
        customLinkedList.insert(15);
        customLinkedList.insert(25);
        customLinkedList.insert(6);
        customLinkedList.insertAt(3,20);
        customLinkedList.deleteNodeAt(5);
        customLinkedList.display();
        System.out.println(customLinkedList.checkLoop());
        customLinkedList.reverse();
        customLinkedList.display();
    }
}
