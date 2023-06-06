/**
 *
 * Autor: Juan Francisco Santos Relinque
 */

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class defIntegration extends Thread{
    // Variables estáticas
    private static double areaParcial = 0;
    
    // Variables de cada objeto
    private int nPuntos;
    private Random rand;
    private double linf, lsup;
    
// -----------------------------------------------------------------------------
    // Constructor
    public defIntegration(int nPuntos, int semilla, double linf, double lsup){
        this.nPuntos = nPuntos;
        rand = new Random(semilla);
        this.linf = linf;
        this.lsup = lsup;
    }
// -----------------------------------------------------------------------------
    public void run(){
        double x, y;
        int nAciertos = 0;
        for(int i=0; i<nPuntos; i++){
            x = linf + (lsup-linf)*rand.nextDouble();
            y = rand.nextDouble();
            if(y <= funcion(x)){
                nAciertos++;
            }
        }
        try {
            actualizaResultado((double)nAciertos/(nPuntos/(lsup-linf)));
        } catch (InterruptedException ex) {
            Logger.getLogger(defIntegration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
// -----------------------------------------------------------------------------
    // Función que actualiza el resultado
    private synchronized void actualizaResultado(double res) throws InterruptedException{
        areaParcial = areaParcial + res;
    }
    
    // Función a integrar
    public static double funcion(double x){
        return (Math.pow(x, 5)+1)/((3*Math.pow(x,6))+6);
    }
    
// -----------------------------------------------------------------------------
    // Main
    public static void main(String[] args) throws InterruptedException {
        int puntosSecuencial = 15000000;
        int puntosHilos = puntosSecuencial/5;
        long tSecuencial, tHilos;
        double resSecuencial, resHilos;
        defIntegration tasks[] = new defIntegration[5];
        
        areaParcial = 0;
        tSecuencial = System.nanoTime();
        tasks[0] = new defIntegration(puntosSecuencial, (int)tSecuencial, 0, 5);
        tasks[0].start();
        tasks[0].join();
        tSecuencial = System.nanoTime() - tSecuencial;
        
        resSecuencial = areaParcial;
        
        for(int i=0; i<5; i++){
            tasks[i] = new defIntegration(puntosHilos, (int)tSecuencial+i, i, i+1);
        }
        areaParcial = 0;
        tHilos = System.nanoTime();
        for(int i=0; i<5; i++){
            tasks[i].start();
        }
        for(int i=0; i<5; i++){
            tasks[i].join();
        }
        tHilos = System.nanoTime() - tHilos;
        
        resHilos = areaParcial;
     
        System.out.println("Tiempo secuencial: "+tSecuencial+" nanosegundos");
        System.out.println("Tiempo paralelo: "+tHilos+" nanosegundos");
        System.out.println("Integracion secuencial: "+resSecuencial);
        System.out.println("Integracion paralela: "+resHilos);
        System.out.println("Speedup: "+(tSecuencial/tHilos));
    }
}
