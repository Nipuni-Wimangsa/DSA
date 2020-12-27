import java.util.Stack;

public class QueueWithStack {
    private Stack<Integer> s1 = new Stack<Integer>();
    private Stack<Integer> s2 = new Stack<Integer>();

    public void enqueue(int item) {
        s1.push(item);
    }

    public int dequeue() {
        copyS1ToS2();
        return s2.pop();
    }

    public int peek() {
        copyS1ToS2();
        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    private void copyS1ToS2() {
        if(isEmpty())
            throw new IllegalStateException();

        if(s2.isEmpty())
            while (!s1.isEmpty())
                s2.push(s1.pop());
    }
}
