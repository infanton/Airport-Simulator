/*
    Author:     Niko Infanto
    Class:      CIS 3180
    Date:       04.09.2017
 */
package CS3180_Project03;

/**
 * Driver class demonstrating a First in First out Airport Queue.
 *
 * @author nikoinfanto
 */
public class Driver {

    public static void main(String[] args) {
        Queue<String> airport = new Queue();

        System.out.println("=============================================");
        System.out.println("First in First out Airport Queue");
        System.out.println("=============================================\n");

        airport.enqueue("Plane_A");
        System.out.println("On Boarding (" + airport.size() + ") ... [" + airport.toString() + "]");
        airport.enqueue("Plane_B");
        System.out.println("On Boarding (" + airport.size() + ") ... [" + airport.toString() + "]");
        airport.enqueue("Plane_C");
        System.out.println("On Boarding (" + airport.size() + ") ... [" + airport.toString() + "]");

        System.out.println("---------------------------------------------");

        System.out.println("TAKE OFF ... " + airport.dequeue());

        System.out.println("---------------------------------------------");

        System.out.println("On Boarding (" + airport.size() + ") ... [" + airport.toString() + "]");
        airport.enqueue("Plane_D");
        System.out.println("On Boarding (" + airport.size() + ") ... [" + airport.toString() + "]");

        System.out.println("---------------------------------------------");
        System.out.println("TAKE OFF ... " + airport.dequeue() + "");
        System.out.println("TAKE OFF ... " + airport.dequeue() + "");
        System.out.println("TAKE OFF ... " + airport.dequeue());
        System.out.println("---------------------------------------------");

        airport.enqueue("Plane_F");
        System.out.println("On Boarding (" + airport.size() + ") ... [" + airport.toString() + "]");

        System.out.println("---------------------------------------------");

        System.out.println("TAKE OFF ... " + airport.dequeue());

        System.out.println("---------------------------------------------");

    }
}
