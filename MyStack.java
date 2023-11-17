public class MyStack<T> extends DoublyLinkedList<T> implements Stack<T> {

    public MyStack() {
        super();
    }


    public void push(T x) {
        prepend(x);
    }


    public T pop() {
        T data = getFirst();
        removeFirst();
        return data;
    }


    public T peek() {
        return getFirst();
    }


    public boolean isEmpty() {
        return getLength() == 0;
    }


    public int getLength() {
        return super.getLength();
    }
}
