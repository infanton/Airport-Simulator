/*
    Author:     Niko Infanto
    Class:      CIS 3180
    Date:       04.09.2017
    Reference:  http://stackoverflow.com/questions/69192/how-to-implement-a-queue-using-two-stacks , adt.scm  
 */
package CS3180_Project03;

import java.util.Objects;

/**
 *
 * The Queue class represents a first-in-first-out (FIFO) stack of objects. In a
 * FIFO queue, all new elements are inserted at the tail of the queue.
 *
 * @since 2017-04-21
 * @param <T>
 *
 */
public class Queue<T> {

    private Stack<T> inputStack;
    private Stack<T> outputStack;
    private int size;

    Queue() {
        this.inputStack = new Stack();
        this.outputStack = new Stack();
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions.
     *
     * @param data - the element to add
     */
    public void enqueue(T data) {
        this.inputStack.push(data);
        this.size++;
    }

//;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
//;; ADT Queue Observers
//;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    
    /**
     * Retrieves and removes the head of this queue.
     *
     * @return the head of this queue
     */
    public T dequeue() {
        if (this.outputStack.isEmpty()) {
            while (!this.inputStack.isEmpty()) {
                this.outputStack.push(this.inputStack.pop());
            }
        }

        T temp = null;
        if (!this.outputStack.isEmpty()) {
            temp = this.outputStack.pop();
            size--;
        }

        return temp;

    }
   
    /**
     * Return the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns a copy of this Queue instance.
     *
     * @return a copy of this instance
     */
    public Queue<T> copy() {

        int counter = this.size;
        Queue<T> copy = new Queue();

        for (int i = 0; i < counter; i++) {
            T data = this.dequeue();
            copy.enqueue(data);
            this.enqueue(data);
        }
        return copy;
    }
    
    /**
     * Removes all of the elements from the queue.
     */
    public void clear() {
        this.inputStack = new Stack();
        this.outputStack = new Stack();
        this.size = 0;
    }
   
    /**
     * Indicates whether some other queue is "equal to" this one.
     *
     * @param other - the reference object with which to compare.
     * @return true if this queue is the same as the queue argument; false
     * otherwise.
     */
    @Override
    public boolean equals(Object other) {

        if (!this.getClass().getName().equals(other.getClass().getName())) {
            return false;
        }

        Queue<T> otherQ = (Queue) other;

        if (this.size != otherQ.size()) {
            return false;
        }

        int qSize = this.size();
        Queue<T> tempThis = this.copy();
        Queue<T> tempOther = otherQ.copy();

        while (tempThis.size() != 0) {

            if (!tempThis.dequeue().toString().equals(tempOther.dequeue().toString())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.inputStack);
        hash = 59 * hash + Objects.hashCode(this.outputStack);
        hash = 59 * hash + this.size;
        return hash;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        Queue<T> tempThis = this.copy();

        while (tempThis.size != 0) {
            str.append(tempThis.dequeue()).append(" ");
        }
        return str.toString().trim();
    }

}
