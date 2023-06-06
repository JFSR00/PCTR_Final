/**
 *
 * Autor: Juan Francisco Santos Relinque
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class usaMyBarrier extends Thread{
    private myBarrier barrera;
    
    public usaMyBarrier(myBarrier barrera){
        this.barrera = barrera;
    }
    
    @Override
    public void run(){
        try {
            System.out.println(this.getName()+" llegando a barrera...");
            barrera.toWaitOnBarrier();
            System.out.println(this.getName()+" saliendo de barrera...");
        } catch (InterruptedException ex) {
            Logger.getLogger(usaMyBarrier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("main creando barrera para tres hebras...");
        myBarrier barrera = new myBarrier(3);
        
        usaMyBarrier h0 = new usaMyBarrier(barrera);
        usaMyBarrier h1 = new usaMyBarrier(barrera);
        usaMyBarrier h2 = new usaMyBarrier(barrera);
        usaMyBarrier h3 = new usaMyBarrier(barrera);
        usaMyBarrier h4 = new usaMyBarrier(barrera);
        usaMyBarrier h5 = new usaMyBarrier(barrera);
        
        h0.start();
        h1.start();
        h2.start();
        
        barrera.resetBarrier();
        
        System.out.println("main reseteando barrera para tres nuevas hebras...");
        
        h3.start();
        h4.start();
        h5.start();
        
        System.out.println("main terminando...");
    }
}
