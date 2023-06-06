/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_problema2;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class tareaRunnable implements Runnable{
    private static int n;
    private int i;
    private final boolean inc;
    
    public tareaRunnable(int i_, boolean inc_){
        i=i_;
        inc=inc_;
    }
    
    @Override
    public void run(){
        while(i>0){
            if(inc)
                incremento();
            else
                decremento();
            i--;
        }
    }
    
    public static int getN(){
        return n;
    }
    
    public static void setN(int num){
        n = num;
    }
    
    private void incremento(){
        n++;
    }
    
    private void decremento(){
        n--;
    }
    
}
