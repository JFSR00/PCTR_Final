/*
2. Escriba un programa que cree tres hebras concurrentes que se citen en una
barrera utilizando la clase CyclicBarrier. Guarde el c´odigo en barrera.java
 */
package p9_problema2;

import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class barrera extends Thread {
    private static CyclicBarrier barrier = new CyclicBarrier(3);
    
    private long sleepTime;
    
    public barrera(String name, long sleepTime){
        super(name);
        this.sleepTime = sleepTime;
    }
    
    @Override
    public void run(){
        try{
            this.sleep(sleepTime);
            barrier.await();
            System.out.println("Llegó el hilo "+this.getName());
        } catch(Exception e) {
            System.out.println("ERROR: "+e.toString());
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Comienza el porgrama:");
        
        barrera b0 = new barrera("Barrera_0", 0);
        barrera b1 = new barrera("Barrera_1", 1000);
        barrera b2 = new barrera("Barrera_2", 3000);
        
        b0.start();
        b1.start();
        b2.start();
        
        b0.join();
        b1.join();
        b2.join();
        
    }
    
}
