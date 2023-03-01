/*** S1.2 Nivell 1 exercici 1 ***/
package n1exercici1;

public class VendaBuidaException extends Exception{
    private String message;
    public VendaBuidaException(String message) {    //Defining constructor
        super(message);
    }

}
