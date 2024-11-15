package org.example.demo.training;

public class Chain<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {

        T data;
        Node<T> next;
        Node<T> previous;

        Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (first == null) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
        size++;
    }

    public T get(int index) {
        return findElement(index).data;
    }

    //TODO
    public void remove(int index) {
        removeMidElement3(index);
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node<T> findElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        int mid = NumberUtils.mid(size);
        Node<T> current;
        if (index < mid) {
            // left
            current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            // right
            current = last;
            for (int i = size() - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return current;
    }

    private void removeMidElement3(int index) {
        Node<T> current = findElement(index);
        Node<T> previous = current.previous;
        Node<T> next = current.next;
        if (previous != null) {
            previous.next = next;
        }
        if (next != null) {
            next.previous = previous;
        }
        if (first == current) {
            first = next;
        }
        if (last == current) {
            last = previous;
        }
    }
}
