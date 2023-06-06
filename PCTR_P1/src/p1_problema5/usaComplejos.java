/*
5. Utilice arrays para implantar una clase que modele numeros complejos.
Dotela de metodos que permitan calcular suma, resta, modulo, producto y co-
ciente. Guarde su trabajo en Complejos.java. Escriba ahora un programa lla-
mado usaComplejos.java que presenta un menu de usuario que permitira elegir
la operacion a realizar y posteriormente leera los datos necesarios para hacerla,
ofreciendo finalmente el resultado en pantalla.
 */
package p1_problema5;

import java.util.Scanner;
/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class usaComplejos {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int opt = 6;
        Complejos a = new Complejos(new double[]{0,0});
        Complejos b = new Complejos(new double[]{0,0});
        
        while(opt != 0){
            System.out.print(""
                    + "COMPLEJOS\n"
                    + "---------\n"
                    + "\n"
                    + "1. Suma\n"
                    + "2. Resta\n"
                    + "3. Producto\n"
                    + "4. Cociente\n"
                    + "5. Modulo\n"
                    + "\n"
                    + "0. Salir\n"
                    + "\n"
                    + "Operacion: "
            );
            
            opt = s.nextInt();
            
            if(opt >= 1 && opt <= 4){
                System.out.println("Introduccion operando A");
                a = readComplejos();
                
                System.out.println("Introduccion operando B");
                b = readComplejos();
            }else if(opt == 5){
                System.out.println("Introduccion operando A");
                a = readComplejos();
            }
            
            switch(opt){
                case 1:
                    a = Complejos.suma(a, b);
                    System.out.println(""
                            + "\n"
                            + "Suma: " + a.getReal() + " " + a.getImaginario() + "i"
                            + "\n"
                    );
                    break;
                case 2:
                    a = Complejos.resta(a, b);
                    System.out.println(""
                            + "\n"
                            + "Resta: " + a.getReal() + " " + a.getImaginario() + "i"
                            + "\n"
                    );
                    break;
                case 3:
                    a = Complejos.producto(a, b);
                    System.out.println(""
                            + "\n"
                            + "Producto: " + a.getReal() + " " + a.getImaginario() + "i"
                            + "\n"
                    );
                    break;
                case 4:
                    a = Complejos.cociente(a, b);
                    System.out.println(""
                            + "\n"
                            + "Cociente: " + a.getReal() + " " + a.getImaginario() + "i"
                            + "\n"
                    );
                    break;
                case 5:
                    System.out.println(""
                            + "\n"
                            + "Modulo: " + Complejos.modulo(a)
                            + "\n"
                    );
                default:
                    break;
            }
        }
    }
    
    public static Complejos readComplejos(){
        Scanner s = new Scanner(System.in);
        double[] complex = new double[]{0,0};
        
        System.out.print("Introduzca parte real: ");
        complex[0] = s.nextInt();
        
        System.out.print("\nIntroduzca parte imaginaria: ");
        complex[1] = s.nextInt();
        
        System.out.print("\n");
        
        return new Complejos(complex);
    }
}
