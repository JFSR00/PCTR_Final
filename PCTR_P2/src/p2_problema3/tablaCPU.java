/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_problema3;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class tablaCPU {
    
    public static void main(String[] args) throws Exception{
        long t1, t2;
        int avaibleThreads = Runtime.getRuntime().availableProcessors();
        int tamVentana = 0;
        escalaVPar hilos[] = new escalaVPar[avaibleThreads];
        
        for(int i=10; i<=150; i+=10){
            escalaVPar.initVector(i*(int)Math.pow(10, 6));
            tamVentana = escalaVPar.vectorLentgth()/avaibleThreads;
            t1=System.currentTimeMillis();
            for(int j = 0; j < avaibleThreads; j++){
                hilos[j] = new escalaVPar(j * tamVentana, (j+1) * tamVentana);
                hilos[j].start();
            }
            for(int j = 0; j < avaibleThreads; j++)
                hilos[j].join();
            
            t2=System.currentTimeMillis();
            System.out.println("Tiempo para tamaño " + i + "*10^6: " + (t2-t1));
        }
    }
}
