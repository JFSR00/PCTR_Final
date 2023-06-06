/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p6_problema3;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class usaHeterogenea extends Thread{
    
    private heterogenea obj;
    
    public usaHeterogenea(heterogenea obj){
        this.obj = obj;
    }
    
    @Override
    public void run(){
        obj.incN(2);
        obj.incM(2);
        obj.incN(-1);
        obj.incM(-1);
    }
    
    public static void main(String[] args) throws InterruptedException{
        int numHilos = 10000;
        heterogenea obj = new heterogenea();
        usaHeterogenea[] hilos = new usaHeterogenea[numHilos];
        
        for(int i = 0; i<numHilos; i++)
            hilos[i] = new usaHeterogenea(obj);
        
        for(usaHeterogenea h: hilos)
            h.start();
        
        for(usaHeterogenea h: hilos)
            h.join();
        
        System.out.println("n = " + obj.getN());
        System.out.println("m = " + obj.getM());
    }
}
