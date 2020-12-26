import java.util.Arrays;

public class Stack {
    private int[] stack;
    private int count;

    public Stack(int size) {
        stack = new int[size];
    }

    public void push(int item) {
        if (count == stack.length)
            throw new StackOverflowError();

        stack[count++] = item;
    }

    public int pop() {
        if(count == 0)
            throw new IllegalStateException();

        return stack[--count];
    }

    public int peek() {
        if(count == 0)
            throw new IllegalStateException();

        return stack[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        int[] content = Arrays.copyOf(stack, count);
        return Arrays.toString(content);
    }

}
