/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p6_problema2;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class arrSeguro extends Thread{
    // Estático
    private static final int size = 10000;
    private static int[] array = new int[size];
    private static Object lock = new Object();
    
    // Variables de objeto
    private int i, n, inc;
    private boolean inc_dec;
    
    public arrSeguro(int i, int n, int inc, boolean inc_dec){
        this.i = i%size;
        this.n = n%(size+1);
        this.inc = inc;
        this.inc_dec = inc_dec;
    }
    
    @Override
    public void run(){
        synchronized(lock){
            for(int j = i; j<n; j++)
                array[j] += inc_dec ? inc : -inc;
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        arrSeguro h1 = new arrSeguro(0, size, 1, true);
        arrSeguro h2 = new arrSeguro(0, size, 1, true);
        arrSeguro h3 = new arrSeguro(0, size, 1, false);
        arrSeguro h4 = new arrSeguro(0, size, 1, true);
        arrSeguro h5 = new arrSeguro(0, size, 1, true);
        arrSeguro h6 = new arrSeguro(0, size, 1, false);
        arrSeguro h7 = new arrSeguro(0, size, 1, false);
        
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        h6.start();
        h7.start();
        
        h1.join();
        h2.join();
        h3.join();
        h4.join();
        h5.join();
        h7.join();
        
        for(int i = 0; i<size; i++){
            if(i%100 == 0){
                System.out.println();
            }
            System.out.print(array[i] + " ");
        }
    }
    
}
