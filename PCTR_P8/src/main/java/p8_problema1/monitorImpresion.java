/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p8_problema1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class monitorImpresion {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition impLibres = lock.newCondition();
    private static int impresoras = 3;
    private static boolean libres[] = new boolean[impresoras];
    
    public int take_print() throws InterruptedException{
        lock.lock();
        int res = -1;
        if(impresoras > 0){
            for(int i=0; i<libres.length && res == -1; i++){
                if(libres[i]){
                    res = i;
                    impresoras--;
                    libres[i] = false;
                    break;
                }
            }
        }
        if(impresoras == 0){
            impLibres.await();
        }
        lock.unlock();
        return res;
    }
    
    public void drop_print(int prt){
        lock.lock();
        
        libres[prt] = true;
        impresoras++;
        
        impLibres.signal();
        
        lock.unlock();
    }
    
}
