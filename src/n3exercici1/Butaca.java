/*** S1.2 Nivell 3 exercici 1 ***/
package n3exercici1;

public class Butaca {
    private int numDeFila;
    private int numDeButaca;
    private String persona;

    /* Constructor */

    public Butaca(int numDeFila, int numDeButaca, String persona) {
        this.numDeFila=numDeFila;
        this.numDeButaca=numDeButaca;
        this.persona=persona;
    }

    /* Getters and setters */
    public int getNumDeFila() {
        return numDeFila;
    }

    public void setNumDeFila(int numDeFila) {
        this.numDeFila = numDeFila;
    }

    public int getNumDeButaca() {
        return numDeButaca;
    }

    public void setNumDeButaca(int numDeButaca) {
        this.numDeButaca = numDeButaca;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }
    /* Overriding hashcode and equals */

    @Override
    public int hashCode() {
        return persona.hashCode()+numDeFila+numDeButaca;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) {
            return true;
        }
        if(!(obj instanceof Butaca)) {
            return false;
        }
        Butaca butaca=(Butaca) obj;
        return this.getNumDeFila()==butaca.getNumDeFila() && this.getNumDeButaca()==butaca.getNumDeButaca();
    }

    /* Overriding toString method */
    @Override
    public String toString() {
        return "Fila: "+this.getNumDeFila()+","+" Seient: "+this.getNumDeButaca()+","+" Persona: "+this.getPersona();
    }
}
