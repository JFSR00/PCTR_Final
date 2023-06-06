/**
 *
 * Autor: Juan Francisco Santos Relinque
 */

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class defIntegration implements Runnable{
    // Variables estáticas
    private static final Semaphore sem = new Semaphore(1);
    private static double intParcial = 0;
    
    // Variables de cada objeto
    private int nPuntos;
    private Random rand;
    private double a, b;
    
// -----------------------------------------------------------------------------
    // Constructor
    public defIntegration(int nPuntos, int semilla, double inicio, double fin){
        this.nPuntos = nPuntos;
        rand = new Random(semilla);
        a = inicio;
        b = fin;
    }
// -----------------------------------------------------------------------------
    public void run(){
        double x, y;
        int nAciertos = 0;
        for(int i=0; i<nPuntos; i++){
            x = a + (b-a)*rand.nextDouble();
            y = rand.nextDouble();
            if(y <= funcion(x)){
                nAciertos++;
            }
        }
        try {
            actualizaResultado((double)nAciertos/nPuntos);
        } catch (InterruptedException ex) {
            Logger.getLogger(defIntegration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
// -----------------------------------------------------------------------------
    // Función que actualiza el resultado
    private void actualizaResultado(double res) throws InterruptedException{
        sem.acquire();
        intParcial = intParcial + res;
        sem.release();
    }
    
    // Función a integrar
    public static double funcion(double x){
        return (2*Math.pow(x, 4))/((3*Math.pow(x,6))+3);
    }
    
// -----------------------------------------------------------------------------
    // Main
    public static void main(String[] args) throws InterruptedException {
        int puntosSecuencial = 18000000;
        int puntosHilos = puntosSecuencial/6;
        long tSecuencial, tHilos;
        double resSecuencial, resHilos;
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(6);
        
        intParcial = 0;
        tSecuencial = System.nanoTime();
        executor.execute(new defIntegration(puntosSecuencial, (int)tSecuencial, 0, 6));
        executor.awaitTermination(3,TimeUnit.SECONDS);
        tSecuencial = System.nanoTime() - tSecuencial;
        
        resSecuencial = intParcial;
        
        intParcial = 0;
        tHilos = System.nanoTime();
        for(int i=0; i<6; i++){
            executor.execute(new defIntegration(puntosHilos, (int)tSecuencial+i, 0, i+1));
        }
        executor.awaitTermination(3,TimeUnit.SECONDS);
        tHilos = System.nanoTime() - tHilos;
        
        resHilos = intParcial;
     
        System.out.println("Tiempo secuencial: "+tSecuencial+" nanosegundos");
        System.out.println("Tiempo paralelo: "+tHilos+" nanosegundos");
        System.out.println("Integracion secuencial: "+resSecuencial);
        System.out.println("Integracion paralela: "+resHilos);
        System.out.println("Speedup: "+(tSecuencial/tHilos));
    }
}
