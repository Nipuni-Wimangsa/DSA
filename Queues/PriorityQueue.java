import java.util.Arrays;

public class PriorityQueue {
    private int[] items;
    private int count;

    public PriorityQueue (int capacity) {
        items = new int[capacity];
    }

    public void add(int item) {
        if(count == items.length)
            throw new IllegalStateException();

        int i;

        for(i = count-1; i >= 0; i--) {
            if (items[i] > item)
                items[i + 1] = items[i];
            else {
                break;
            }
        }

        items[i+1] = item;
        count++;
    }

    public int remove() {
        if(count == 0)
            throw new IllegalStateException();

        return items[--count];
    }

    @Override
    public String toString() {
        int[] content = Arrays.copyOf(items, count);
        return Arrays.toString(content);
    }
}
