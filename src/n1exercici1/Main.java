/*** S1.2 Nivell 1 exercici 1 ***/
package n1exercici1;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        new Venda().generarVenda();



    /**** Now we want to generate and catch and ArrayIndexOutOfBoundsException ***/
        int[] array=new int[((int)Math.random()*100)%100];     //Generating array with random capacity between 0-99. Funny, isn't it?
        try {
            array[array.length] = 0;    //Trying to access non-existing position in the array;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("We've generated an ArrayIndexOutOfBoundsException");    //Well...we knew this gonna happen
        }

    }
}