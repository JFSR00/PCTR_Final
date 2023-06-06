/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p6_problema4;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.SysexMessage;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class deadlock extends Thread{
    
    private Object lock1, lock2;
    private String str;
    
    public deadlock(Object lock1, Object lock2, String str){
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.str = str;
    }
    
    @Override
    public void run(){
        synchronized(lock1){
            try{
                sleep(1);
            }catch(InterruptedException ex){}
            synchronized(lock2){
                System.out.println("No llega aquí " + str);
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Object lock3 = new Object();
        
        deadlock h1 = new deadlock(lock1, lock2, "Hilo 1");
        deadlock h2 = new deadlock(lock2, lock3, "Hilo 2");
        deadlock h3 = new deadlock(lock3, lock1, "Hilo 3");
        
        h1.start();
        h2.start();
        h3.start();
        
        h1.join();
        h2.join();
        h3.join();
        
        System.out.println("Fin del programa");
        
    }
    
}
