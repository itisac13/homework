public interface Queue<T> {
    void enqueue(T x);
    T dequeue();
    T peek();
    boolean isEmpty();
    int getLength();
}
