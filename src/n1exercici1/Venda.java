/*** S1.2 Nivell 1 exercici 1 ***/
package n1exercici1;

import java.util.*;


public class Venda {
    private List<Producte> llista=new ArrayList<>();    //Defining attributes
    private Double preu=null;
    public Venda(List llista) {    //Constructor takes a list as a parameter
        this.setLlista(llista);
    }

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
