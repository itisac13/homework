public class MyQueue<T> extends DoublyLinkedList<T> implements Queue<T> {

    public MyQueue() {
        super();
    }


    public void enqueue(T x) {
        append(x);
    }


    public T dequeue() {
        if (!isEmpty()) {
            T data = getLast();
            removeLast();
            return data;
        } else {
            return null;
        }
    }

    public T peek() {
        if (!isEmpty()) {
            return getLast();
        } else {
            return null;
            // or throw an exception or return a specific value indicating an empty queue
        }
    }

    public boolean isEmpty() {
        return getLength() == 0;
    }


    public int getLength() {
        return super.getLength();
    }
}