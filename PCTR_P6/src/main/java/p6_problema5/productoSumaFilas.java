/*
5. Deseamos calcular el producto de los números resultantes de sumar
las filas de una matriz de enteros de diez filas por cien columnas. Utilizando
tareas soportadas por Callable y la interfaz Future, escriba en
productoSumaFilas.java un programa en Java que efectúe la tarea. En
este caso, prescinda de la ecuación de Subramanian, y utilice diez tareas concurrentes.
 */
package p6_problema5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class productoSumaFilas implements Callable<Integer>{

    private static Integer[][] matriz = new Integer[10][100];
    
    private int fila;
    
    public productoSumaFilas(int fila){
        this.fila = fila;
    }
    
    @Override
    public Integer call() throws Exception {
        int res = 0;
        for(Integer n: matriz[fila])
            res += n.intValue();
        
        return new Integer(res);
    }
    
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        int res = 1;
        for(Integer[] i: matriz)
            for(int j=0; j<i.length; j++)
                i[j] = new Integer((int)(Math.random()*100));
        
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        List<Future<Integer>> resultadosParciales = new ArrayList<Future<Integer>>();
        
        for(int i=0; i<10; i++)
            resultadosParciales.add(executor.submit(new productoSumaFilas(i)));
        
        for(Future<Integer> n: resultadosParciales)
            res *= n.get().intValue();
        
        System.out.println("Resultado paralelo:\t" + res);
        System.out.println("Resultado secuencial:\t" + secuencial());
        
        executor.shutdown();
    }
    
    public static int secuencial(){
        int res = 1;
        int aux = 0;
        
        for(Integer[] i: matriz){
            aux = 0;
            for(Integer j: i)
                aux+=j.intValue();
            res*=aux;
        }
        
        return res;
    }
}
