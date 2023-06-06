package p2_problema1;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
1. Utilizando herencia de la clase Thread, cree una condicion de concurso1
sobre una variable comun n (valor inicial 0) entre dos hilos que respectivamente
incrementen y decrementen el mismo numero de veces a n: Lance ambos hilos
concurrentemente utilizando y compruebe que, aunque el valor teorico final debe
ser cero, en la practica no tiene por que ser asi. Guarde su codigo en hebra.java
y Usa hebra.java. Escriba (utilizando LATEX vía OverLeaf ) una corta tabla de
prueba en tabla.pdf donde recogera el numero de iteraciones que realizaron
los hilos y el valor final obtenido para n junto con sus impresiones acerca de
todo ello.
 */

/**
 *
 * @author Juan Francisco Santos Relinque
 */

public class Usa_hebra {
    public static void main(String[] args) throws InterruptedException{
        for(int i=1; i<=10; i++){
            hebra.n = 0;
            
            hebra h1 = new hebra(i*100000, true);
            hebra h2 = new hebra(i*100000, false);

            h1.start();
            h2.start();

            h1.join();
            h2.join();
            
            System.out.println("Iteraciones: " + i*100000);
            System.out.println("n = " + hebra.n);
        }
    }
}
