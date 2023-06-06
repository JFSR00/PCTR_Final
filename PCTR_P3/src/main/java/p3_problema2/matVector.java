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

import java.util.Random;
import p3_problema1.*;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class matVector {
    private final static int tam = (int)Math.pow(10, 4);
    
    private static int v1[][], v2[];
    
    public static void main(String[] args){
        // Declaración de variables
        long t1, t2;
        int res[];
        Random rand = new Random();
        
        // Declaración de matrices
        v1 = new int[tam][tam];
        v2 = new int[tam];
        
        // Inicialización de matrices
        for(int i=0; i<tam; i++){
            for(int j=0; j<tam; j++){
                v1[i][j]=rand.nextInt();
            }
            v2[i]=rand.nextInt();
        }
        
        // Ejecución de producto y ejecución de tiempo
        t1=System.currentTimeMillis();
        res = productoMatricial(v1, v2, tam);
        t2=System.currentTimeMillis();
        
        // Impresión de matrices
        /*
        System.out.println();
        for(int i=0; i<tam; i++){
            for(int j=0; j<tam; j++){
                System.out.print(v1[i][j] + "\t");
            }
            System.out.println("\t\t" + v2[i]);
        }
        System.out.println();
        */
        
        // Resultados
        System.out.println("Tiempo para tamaño " + tam + ": " + (t2-t1) + " ms");
        if(tam <= 20){
            System.out.println("Resultado:");
            for(int n: res)
                System.out.print(n + " ");
            System.out.println();
        }
    }
    
    public static int[] productoMatricial(int[][] v1, int[] v2, int n){
        int res[] = new int[n];
        
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                res[i] += v1[i][j]*v2[j];
        
        return res;
    }
}
