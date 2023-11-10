import java.util.Comparator;

public class SinglyLinkedList<T> {

    // Node class representing each element in the list
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head; // Reference to the first node in the list

    public SinglyLinkedList() {
        this.head = null;
    }

    public void append(T data) {
        Node<T> newNode = new Node<>(data);

        // if list is empty, set the head to the data
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;

            // get tail node
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to add a new element to the beginning of the list
    public void prepend(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }


    public void print() {
        String output = "[";
        Node<T> current = head;
        while (current != null) {
            output += (current.data + ", ");
            current = current.next;
        }
        output += "]";
        System.out.println(output);
    }

    public void printReverse() {
        String output = "[";
        Node<T> current = head;
        while (current != null) {
            output += (", " + current.data);
            current = current.next;
        }
        output += "]";
        System.out.println(output);
    }
    public void insertAfter(int index, T data) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative");
        }

        Node<T> newNode = new Node<>(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            int currentIndex = 0;


            // loop through list until desired index is encountered
            while (current != null && currentIndex < index - 1) {
                current = current.next;
                currentIndex++;
            }


            if (current == null) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }

            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void remove(T data) {
        if (head == null) {
            // If the list is empty, do nothing
            return;
        }

        if (head.data.equals(data)) {
            // If the first node contains the specified data, remove it
            head = head.next;
            return;
        }

        Node<T> current = head;
        Node<T> previous = null;

        while (current != null && !current.data.equals(data)) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            // If the data is found, remove the node
            previous.next = current.next;
        }
    }

    // Method to search for the first occurrence of specified data and return its index
    public int search(T data) {
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            if (current.data.equals(data)) {
                return index; // Found the data, return its index
            }

            current = current.next;
            index++;
        }

        // Data not found, raise an exception
        throw new IllegalArgumentException("Data not found in the list");
    }


    public void sort(Comparator<? super T> comparator) {
        if (head == null || head.next == null) {
            // If the list is empty or has only one element, it's already sorted
            return;
        }

        boolean swapped;
        Node<T> lastNode = null;

        do {
            swapped = false;
            Node<T> current = head;
            Node<T> previous = null;

            while (true) {
                if (current == null || current.next == null)
                    break;

                if (comparator.compare(current.data, current.next.data) > 0) {
                    // Swap elements if they are in the wrong order
                    Node<T> temp = current.next;
                    current.next = temp.next;
                    temp.next = current;

                    if (previous == null) {
                        // Update head if the first element is swapped
                        head = temp;
                    } else {
                        previous.next = temp;
                    }

                    swapped = true;
                }

                previous = current;
                current = current.next;
            }

            lastNode = current;
        } while (swapped);
    }
    public boolean isEmpty() {
        return head == null;
    }

    public int getLength() {
        int length = 0;
        Node<T> current = head;
        // traverse the list and simply keep count of the elements until the tail node is reached
        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }



    public static void main(String[] args) {
        SinglyLinkedList<String> disciples = new SinglyLinkedList<>();
        disciples.append("Simon Peter");
        disciples.append("James son of Zebedee");
        disciples.append("John");
        disciples.append("Andrew");
        disciples.append("Bartholomew");
        disciples.append("James son of Alphaeus");
        disciples.append("Judas");
        disciples.append("Jude");
        disciples.append("Matthew");
        disciples.append("Phillip");
        disciples.append("Simon the Zealot");
        disciples.append("Thomas");

        disciples.print();

        disciples.remove("Judas");
        disciples.print();

        disciples.sort(Comparator.naturalOrder());
        disciples.printReverse();

    }

}
