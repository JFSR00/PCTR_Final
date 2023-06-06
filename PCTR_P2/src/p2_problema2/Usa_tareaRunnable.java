/*
2. Utilizando implementacion de la interfaz Runnable, cree una condicion
de concurso sobre una objeto comun que albergara una variable entera n con
valor inicial 0. La clase que modela al objeto tendra dos modificadores que respectivamente
incrementen y decrementen a la variable n, y un observador para
conocer su estado. Lance ambos hilos (uno que incremente y otro que decremente)
concurrentemente utilizando y compruebe que, aunque el valor teorico
final de n debe ser cero, en la practica no tiene por que ser asi. Guarde su
codigo en tareaRunnable.java y Usa tareaRunnable.java. Escriba (utilizando
LATEX via OverLeaf ) una corta tabla de prueba en tabla.pdf donde recogera
el numero de iteraciones que realizaron los hilos y el valor final obtenido para n
junto con sus impresiones acerca de todo ello.
 */
package p2_problema2;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class Usa_tareaRunnable {
    public static void main(String[] args) throws Exception{
        for(int i=1; i<=5; i++){
            tareaRunnable.setN(0);
            
            Thread h1 = new Thread(new tareaRunnable(100000, true));
            Thread h2 = new Thread(new tareaRunnable(100000, false));

            h1.start();
            h2.start();

            h1.join();
            h2.join();
            
            System.out.println("Iteraciones: " + i*100000);
            System.out.println("n = " + tareaRunnable.getN());
        }
    }
}

