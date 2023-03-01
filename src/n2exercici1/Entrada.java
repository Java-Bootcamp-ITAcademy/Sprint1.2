/*** S1.2 Nivell 2 exercici 1 ***/
package n2exercici1;
import java.util.*;

public class Entrada {
    private static Scanner sc=new Scanner(System.in);    //Declaring Scanner class object
    public static Scanner getSCanner() {
        return sc;
    }
    public static byte llegirByte(String missatge) {     //Byte input reading
        byte b=0;
        boolean llegir=true;
        while(llegir) {
            try {         //Try block
                System.out.println(missatge);
                b = sc.nextByte();      //Reading byte input
                llegir=false;
            }
            catch (NullPointerException e) {    //sc reference is null
                System.out.println("Invalid Scanner object");
            } catch (InputMismatchException e) {    //Catching invalid input exception
                System.out.println("Argument invàlid. Torna-ho a intentar");
                sc.next();
            }
        }
        return b;
    }


    public static int llegirInt(String missatge) {    //Int input reading
        int i=0;
        boolean llegir=true;
        while(llegir) {
            try {    //Try block
                System.out.println(missatge);
                i = sc.nextInt();
                llegir=false;
            }
            catch (NullPointerException e) {    //sc reference is null
                System.out.println("Invalid Scanner object");
            } catch (InputMismatchException e) {     //Catching invalid input exception
                System.out.println("Argument invàlid. Torna-ho a intentar");
                sc.next();
            }
        }
        return i;
    }

    public static float llegirFloat(String missatge) {    //Float input reading
        float f=0.0F;
        boolean llegir=true;
        while(llegir) {
            try {    //Try block
                System.out.println(missatge);
                f = sc.nextFloat();
                llegir=false;
            }
            catch (NullPointerException e) {    //sc reference is null
                System.out.println("Invalid Scanner object");
            } catch (InputMismatchException e) {    //Catching invalid input exception
                System.out.println("Argument invàlid. Torna-ho a intentar");
                sc.next();
            }
        }
        return f;
    }

    public static double llegirDouble(String missatge) {    //Double input reading
        double d=0.0;
        boolean llegir=true;
        while(llegir) {
            try {    //Try block
                System.out.println(missatge);
                d = sc.nextDouble();
                llegir=false;
            }
            catch (NullPointerException e) { //sc reference is null
                System.out.println("Invalid Scanner object");
            } catch (InputMismatchException e) {    //Catching invalid input exception
                System.out.println("Argument invàlid. Torna-ho a intentar");
                sc.next();
            }
        }
        return d;
    }

    public static char llegirChar(String missatge) {//Char input reading
        char c=' ';
        boolean llegir=true;
        while(llegir) {
            try {    //Try block
                System.out.println(missatge);
                String s = sc.next();
                if(s.length()==1) {
                    c=s.charAt(0);
                    llegir=false;
                }
                else {
                    throw new Exception();
                }

            }
            catch (Exception e) {
                System.out.println("Argument invàlid");
            }
        }
        return c;
    }

    public static String llegirString(String message) {    //String input reading
        String s=null;
        boolean llegir=true;
        while(llegir) {
            try {    //Try block
                System.out.println(message);
                s = sc.nextLine();
                llegir=false;
            }
            catch (Exception e) {    //Catching exception
                System.out.println("Alguna cosa ha anat malament. Torna-ho a provar");
            }
        }
        return s;
    }
    public static boolean llegirSiNo(String missatge) {    //Boolean input reading
        boolean b=false;
        boolean llegir=true;
        while (llegir) {
            try {    //Try block
                System.out.println(missatge);
                String s = sc.next();
                if (!(s.equals("s") || s.equals("n"))) {
                    throw new Exception();
                } else if (s.equals("s")) {
                    b = true;
                    llegir=false;
                } else {
                    b = false;
                    llegir=false;
                }
            } catch (Exception e) {    //Catching exception
                System.out.println("Introdueix una opció correcta");
            }
        }
        return b;
    }
}
