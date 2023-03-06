/*** S1.2 Nivell 3 exercici 1 ***/
package n3exercici1;

import java.util.ArrayList;

public class GestioDeButaques {
    private ArrayList<Butaca> butaques;

    /* Constructor */
    public GestioDeButaques() {
        this.butaques=new ArrayList<>();
    }

    /* Getter */
    public ArrayList<Butaca> getButaques() {
        return butaques;
    }

    /* Instance methods declaration */
    public void afegirButaca(Butaca butaca) throws Exception {
        if(cercarButaques(butaca.getNumDeFila(),butaca.getNumDeButaca())==-1) {
            butaques.add(butaca);
        }
        else {
            throw new ExcepcioButacaOcupada();
        }
    }

    public void eliminarButaca(int fila, int seient) throws Exception {
        int posicio=cercarButaques(fila, seient);
        if(posicio!=-1) {
            butaques.remove(posicio);
        }
        else {
            throw new ExcepcioButacaLliure();
        }
    }

    public int cercarButaques(int fila, int seient) {
        Butaca butaca=new Butaca(fila, seient,null);
        if(butaques.isEmpty() || !butaques.contains(butaca)) {
            return -1;
        }
        else {
            return butaques.indexOf(butaca);
        }
    }
}
