/*** S1.2 Nivell 3 exercici 1 ***/
package n3exercici1;

import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Cine {
    private static Scanner sc=new Scanner(System.in);
    private int nombreDeFiles;
    private int nombreDeButaquesFila;
    private GestioDeButaques gestioDeButaques;

    /* Constructor */
    public Cine() {

    }

    /* Getters and setters */

    public static Scanner getScanner() {
        return sc;
    }
    public int getNombreDeFiles() {
        return nombreDeFiles;
    }

    public void setNombreDeFiles(int nombreDeFiles) {
        this.nombreDeFiles = nombreDeFiles;
    }

    public int getNombreDeButaquesFila() {
        return nombreDeButaquesFila;
    }

    public void setNombreDeButaquesFila(int nombreDeButaquesFila) {
        this.nombreDeButaquesFila = nombreDeButaquesFila;
    }

    /* Instance methods declaration */
    public void assignarDadesInicial() {
        System.out.println("Quantes files té el cinema?");
        setNombreDeFiles(Integer.parseInt(sc.nextLine()));
        System.out.println("Quantes butaques hi per fila?");
        setNombreDeButaquesFila(Integer.parseInt(sc.nextLine()));
        this.gestioDeButaques=new GestioDeButaques();
    }

    public int menu() {
        System.out.println("Escolliu una opció");
        System.out.println("1-Mostrar totes les butaques reservades");
        System.out.println("2-Mostrar les butaques reservades per una persona");
        System.out.println("3-Reservar una butaca");
        System.out.println("4-Anul·lar la reserva d'una butaca");
        System.out.println("5-Anul·lar totes les reserves d'una persona");
        int menu=Integer.parseInt(sc.nextLine());
        return menu;
    }

    public void iniciar () throws Exception {
        boolean programRunning=true;
        while (programRunning) {
            int opcioEscollida=menu();
            switch (opcioEscollida) {
                case 1: {
                    mostrarButaques(gestioDeButaques);
                    break;
                }
                case 2: {
                    mostrarButaquesPersona(gestioDeButaques);
                    break;
                }
                case 3: {
                    reservarButaca();
                    break;
                }
                case 4: {
                    anularReserva();
                    break;
                }
                case 5: {
                    anularReservaPersona();
                    break;
                }
                case 0: {
                    programRunning=false;
                }
            }
        }
    }

    public void mostrarButaques(GestioDeButaques gestioDeButaques) {
        for(Butaca butaca:gestioDeButaques.getButaques()) {
            System.out.println(butaca);
        }
    }

    public void mostrarButaquesPersona(GestioDeButaques gestioDeButaques) {
        System.out.println("Introduïu nom de la persona:");
        String persona=sc.nextLine();
        for (Butaca butaca:gestioDeButaques.getButaques()) {
            if(butaca.getPersona().equals(persona)) {
                System.out.println(butaca);
            }
        }
    }

    public void reservarButaca() throws Exception {
        int fila=introduirFila();
        int seient=introduirSeient();
        String persona=introduirPersona();
        if(gestioDeButaques.cercarButaques(fila,seient)==-1 || gestioDeButaques.getButaques().isEmpty()) {
            Butaca butaca=new Butaca(fila, seient, persona);
            gestioDeButaques.afegirButaca(butaca);
        }
        else {
            throw new ExcepcioButacaOcupada();
        }
    }

    public void anularReserva() throws Exception {
        int fila=introduirFila();
        int seient=introduirSeient();
        gestioDeButaques.eliminarButaca(fila, seient);
    }

    public void anularReservaPersona() throws Exception {
        String persona=introduirPersona();
        boolean trobat=false;
        Iterator<Butaca> it=gestioDeButaques.getButaques().iterator();
        while(it.hasNext()||!trobat) {
            if(it.next().getPersona().equals(persona)) {
                it.remove();
                trobat=true;
            }
        }
    }
    public int introduirSeient() throws Exception{
        int numeroDeSeient = -1;
        System.out.println("Introduïu número de seient");
        numeroDeSeient = Integer.parseInt(sc.nextLine());
        if (numeroDeSeient < 1 || numeroDeSeient > nombreDeButaquesFila) {
            throw new ExcepcioSeientIncorrecte();
        }
        return numeroDeSeient;
    }

    public int introduirFila() throws Exception {
        int numeroDeFila = -1;
        System.out.println("Introduïu número de fila");
        numeroDeFila = Integer.parseInt(sc.nextLine());
        if (numeroDeFila < 1 || numeroDeFila > nombreDeFiles) {
            throw new ExcepcioFilaIncorrecta();
        }
        return numeroDeFila;
    }

    public String introduirPersona() throws Exception {
        String nom = "";
        System.out.println("Introduïu el nom de la persona");
        nom = sc.nextLine();
        for(int i=0;i<nom.length();i++) {
            if (Character.isDigit(nom.charAt(i))) {
                throw new ExcepcioNomPersonaIncorrecte();
            }
        }
        return nom;
    }



}
