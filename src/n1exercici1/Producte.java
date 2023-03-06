/*** S1.2 Nivell 1 exercici 1 ***/
package n1exercici1;

public class Producte {
    private String nom;    //Defining attributes
    private Double preu;

    public Producte(String nom, Double preu) {    //Declaring constructor
        this.nom=nom;
        this.preu=preu;
    }

    public String getNom() {    //Setters and getters
        return nom;
    }    //Setters and getters

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPreu() {
        return preu;
    }

    public void setPreu(Double preu) {
        this.preu = preu;
    }
}
