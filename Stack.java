/* Referenced:  http://stackoverflow.com/questions/69192/how-to-implement-a-queue-using-two-stacks */

/**
 *
 * The Stack class represents a last-in-first-out (LIFO) stack of objects. The usual push and pop operations are provided, as well as a method to peek at the top item on the stack, a method to test for whether the stack is empty, and a method to search the stack for an item and discover how far it is from the top.
 * When a stack is first created, it contains no items.
 * 
 * @since   2017-04-21 
 * @param <T>
 * 
 */
public class Stack<T> {

    // Data Types
    private Node<T> head;
    private int size;

    // Constructor
    Stack() {
        this.head = null;
        this.size = 0;
    }

    // Class Methods

    /**
     * Return the number of elements in this stack.
     * @return the number of elements in this stack
     */
    public int size() {
        return this.size;
    }

    /**
     * Tests if this stack is empty.
     * @return true if this stack is empty; otherwise false
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Pushes an item onto the top of this stack.
     * @param data - the element to add
     */
    public void push(T data) {
        Node<T> newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
        } else {
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     * @return the head of this queue
     */
    public T pop() {
        if (head == null) {
            return null;
        } else {

            T elem = this.head.getData();
            
            this.head = this.head.getNext();
            this.size--;
            return elem;
        }
    }
    
    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     * @return the head of this queue, or null if this queue is empty
     */
    public T peek() {
        if (head == null) {
            return null;
        } else {
            T elem = this.head.getData();
            return elem;
        }
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        
        for(Node<T> temp = this.head; temp != null; temp = temp.getNext()){
            str.append(temp.getData()).append(" ");
        }
        
        return str.toString().trim();
    }

}
