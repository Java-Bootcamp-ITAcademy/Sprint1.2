/*** S1.2 Nivell 1 exercici 1 ***/
package n1exercici1;

import java.util.*;


public class Venda {
    private List<Producte> llista;    //Defining attributes
    private Double preu=null;

    /* Constructor */
    public Venda() {
        this.llista=new ArrayList<>();//Constructor takes a list as a parameter;
    }

    /* Getters and setters */
    public List<Producte> getLlista() {    //Setters and getters
        return llista;
    }

    public void setLlista(List<Producte> llista) {
        this.llista = llista;
    }

    public Double getPreu() {
        return preu;
    }

    public void setPreu(Double preu) {
        this.preu = preu;
    }


    /* Instance methods */
    public void generarVenda() {
        boolean seguir=true;
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
                this.llista.add(producte);
            }
            else if(resposta.equals("N")) {
                seguir=false;
                sc.close();
            }
        }
        try {    //Try block
                //A new Venda is instantiated
            double total=this.calcularTotal();    //Calculating total amount calling method
            System.out.printf("El total de la venda és de %.2f€\n",total);
        }
        catch(VendaBuidaException e) {    //Catch block
            e.printStackTrace();  //Exception error message is printed

        }
    }

    public double calcularTotal() throws VendaBuidaException {    //Calculating groceries total amount
       var total=0.0;
       if(this.getLlista().isEmpty()) {    //Exception is thrown as list is empty
           throw new VendaBuidaException("Per fer una venda primer has d’afegir productes");
       }
       else {
           for (Producte producte : llista) {    //Iterating through non-empty list
               total += producte.getPreu();
           }
       }
       return total;
    }


}
