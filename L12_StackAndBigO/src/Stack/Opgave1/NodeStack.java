package Stack.Opgave1;

import java.util.NoSuchElementException;

public class NodeStack implements stack.StackI {
    private Node top;
    private int size = 0;



    @Override
    public void push(Object element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = (Node) top;
        top = newNode;
        size++;

    }

    @Override
    public Object pop() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        Node element = top;
        top = top.next;
        size--;
        return element.data;
    }

    @Override
    public Object peek() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.data;
    }

    @Override
    public int size() {
        return size;

    }

    @Override
    public boolean isEmpty() {

        return top == null;
    }


    }

class Node {
    public Object data;
    public Node next;
}


