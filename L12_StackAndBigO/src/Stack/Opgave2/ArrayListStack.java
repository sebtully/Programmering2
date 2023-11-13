package Stack.Opgave2;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayListStack implements stack.StackI {
private ArrayList<Object> stack;
    private int top;

    public ArrayListStack() {
        top = -1;
        stack = new ArrayList<>();
    }

    @Override
    public void push(Object element) {
        stack.add(element);
        top++;
    }

    @Override
    public Object pop() {
        if (top < 0) {
            throw new NoSuchElementException();
        }
        Object element = stack.get(top);
        stack.remove(top);
        top--;
        return element;
    }

    @Override
    public Object peek() {
        if (top < 0) {
            throw new NoSuchElementException();
        }
        return stack.get(top);
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}







