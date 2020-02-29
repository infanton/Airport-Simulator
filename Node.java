/*
    Author:     Niko Infanto
    Class:      CIS 3180
    Date:       04.09.2017
    Reference:  http://stackoverflow.com/questions/69192/how-to-implement-a-queue-using-two-stacks
 */

package CS3180_Project03;

/**
 * The Node class represents a single node in the Stack and Queue class. 
 * 
 * @since   2017-04-21 
 * @param <T>
 * 
 */
public class Node<T> {

    // Data Types
    private T data;
    private Node<T> next;
    private Node<T> previous;

    // Constuctors
    Node(T data) {
        this.data = data;
        this.next = null;
    }

    // Getters and Setters 

    /**
     * Gets the value of this node.
     * @return the value of this node
     */
    public T getData() {
        return this.data;
    }

    /**
     * Sets the value of this node.
     * @param data - the element to add
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Gets the node immediately following this node.
     * @return Gets the node immediately following this node
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * Sets the node immediately following this node.
     * @param next - The node immediately following this node. If there is no such node, this returns null.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    /**
     * Gets the node immediately preceding this node.
     * @return the node immediately preceding this node
     */
    public Node<T> getPrevious() {
        return this.previous;
    }

    /**
     * Sets the node immediately preceding this node.
     * @param previous - the node immediately preceding this node
     */
    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

}
