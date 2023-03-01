/*** S1.2 Nivell 1 exercici 1 ***/
package n1exercici1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean seguir=true;
        List<Producte> llista=new ArrayList<>();    //Creating a list of products
        Scanner sc=new Scanner(System.in);
        while(seguir) {    //Adding products into the list
            System.out.println("Vol introduir algun producte? S/N");
            String resposta=sc.nextLine();
            if(resposta.equals("S")) {
                System.out.println("Introdueixi nom del producte");
                String nom=sc.nextLine();
                System.out.println("Introdueixi preu del producte");
                Double preu=Double.parseDouble(sc.nextLine());
                Producte producte=new Producte(nom,preu);
                llista.add(producte);
            }
            else if(resposta.equals("N")) {
                seguir=false;
                sc.close();
            }
        }
        try {    //Try block
            Venda venda=new Venda(llista);    //A new Venda is instantiated
            double total=venda.calcularTotal();    //Calculating total amount calling method
            System.out.printf("El total de la venda és de %.2f€\n",total);
        }
        catch(VendaBuidaException e) {    //Catch block
            e.printStackTrace();  //Exception error message is printed

        }
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