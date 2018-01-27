package com.gracjan;

public class DoubleLinkedList<T> {
    private int counter;
    private Node<T> head;
    private Node<T> tail;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.counter = 0;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = head;

        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        this.counter++;
    }

    public void add(T data, int index) {
        int indexCounter = 0;
        Node<T> newNode = new Node<>(data);
        Node<T> currentNode = this.head;

        if (index < 0 | index > this.counter)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            this.addFirst(data);

        } else {

            while(indexCounter != index) {
                if (currentNode.getNext() == null)
                    return;

                currentNode = currentNode.getNext();
                indexCounter++;
            }
            Node<T> previousNode = currentNode.getPrevious();
            newNode.setNext(currentNode);
            newNode.setPrevious(previousNode);
            previousNode.setNext(newNode);
            currentNode.setPrevious(newNode);
            this.counter++;
        }

    }

    public void remove(int index) {
        int indexCounter = 0;
        Node<T> currentNode = this.head;

        if (index < 0 | index > this.counter)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            this.head = currentNode.getNext();
            this.head.setPrevious(null);

        } else if (index == this.counter - 1) {
            this.tail = tail.getPrevious();
            this.tail.setNext(null);

        } else {

            while(indexCounter != index) {

                if (currentNode.getNext() == null)
                    return;

                currentNode = currentNode.getNext();
                indexCounter++;
            }

            Node<T> previousNode = currentNode.getPrevious();
            Node<T> nextNode = currentNode.getNext();

            nextNode.setPrevious(previousNode);
            previousNode.setNext(nextNode);
        }
        this.counter--;
    }

    public void display() {
        int index = 0;
        Node<T> node = this.head;
        while (node != null) {
            System.out.println(node.getData() + " index: " + index);
            node = node.getNext();
            index++;
        }
    }

    public int getCounter() {
        return counter;
    }
}
