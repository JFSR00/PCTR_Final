/*
2. Se desea disponer de un programa que realice de forma paralela el producto
de una matriz cuadrada de n×n componentes por un vector A· b = y tambi´en
de n componentes.
Ambas estructuras de datos se rellenar´an con datos aleatorios enteros obtenidos
a trav´es de una instancia de la clase Random. Escriba primero un programa
que solucione el problema de forma secuencial, y ll´amelo matVector.java. Reescriba
ahora su programa para realizar el producto de forma paralela mediante
concurrencia por implementaci´on de la interfaz Runnable, utilizando paralelismo
de datos por divisi´on manual del dominio (cada hebra ser´a reponsable
de un n´umero determinado de filas), con diferente n´umero de tareas paralelas
n = 2, 4, 8, ..,16. Cada tarea necesitar´a saber de cu´antas filas es responsable
(por ejemplo, v´ıa constructor). El programa principal crear´a y lanzar´a
las hebras, esperando posteriormente a que terminen. Guarde su trabajo en
matVectorConcurrente.java. Tome tiempos para la versi´on secuencial y las
diferentes versiones paralelas, y construya una curva tiempo = f(hebras). Tome
nota tambi´en de los picos de CPU y construya una curva %CPU = f(hebras)
*/

package p3_problema2;

import p3_problema1.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class matVectorConcurrente implements Runnable{
    // Parámetros del programa
    private static int numHilos[] = {2, 4, 8, 10};
    private final static int tam = (int)Math.pow(10, 6);
    
    // Vectores y variables del programa
    private static double v1[], v2[];
    private static double productoParcial[];

    // Variables de los hilos
    private final int idHebra, inicio, fin;
    
    public matVectorConcurrente(int idHebra, int inicio, int fin) {
        this.idHebra = idHebra;
        this.inicio = inicio;
        this.fin = fin;
    }
    
    @Override
    public void run(){
        productoParcial[idHebra] = 0;
        for(int i=inicio; i<fin; i++){
            productoParcial[idHebra] += v1[i]*v2[i];
        }
    }
    
    public static void main(String[] args) throws InterruptedException{
        // Declaración de variables
        long t1, t2;
        double res;
        int restoElem;
        
        // Declaración de vectores
        v1 = new double[tam];
        v2 = new double[tam];
        
        // Inicialización de vectores con valores aleatorios
        for(int j=0; j<v1.length; j++){
            v1[j]=(double)(Math.random()*10);
            v2[j]=(double)(Math.random()*10);
        }
        
        for(int n: numHilos){
            // Inicialización de variables
            res = 0;
            productoParcial = new double[n];
            restoElem = v1.length % n;  // Calculamos el resto de elementos por si no coincidiese una cantidad exacta de elementos por hilo
            
            // Creamos un vector de hilos
            Thread hilos[] = new Thread[n];
            for(int i=0; i<n; i++)
                hilos[i] = new Thread(i!=(n-1)? new matVectorConcurrente(i, i*(v1.length/n), (i+1)*(v1.length/n)) : new matVectorConcurrente(i, i*(v1.length/n), (i+1)*(v1.length/n)+(restoElem)));
            
            // Lanzamos los hilos y medimos su tiempo de ejecución
            t1=System.currentTimeMillis();
            for(Thread h: hilos)
                h.start();
            for(Thread h: hilos)
                h.join();
            t2=System.currentTimeMillis();
            
            // Realizamos la suma de los productos parciales
            for(int i=0; i<n; i++)
                res += productoParcial[i];
            
            // Mostramos los resultados
            System.out.println();
            System.out.println("Número de hilos: " + n);
            System.out.println("Tiempo para tamaño 10^6: " + (t2-t1) + " ms");
            System.out.println("Resultado: " + res);
        }
    }
}
