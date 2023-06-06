/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_problema1;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class hebra extends Thread{
    public static int n;
    private int i;
    private final boolean inc;
    
    public hebra(int i_, boolean inc_){
        i=i_;
        inc=inc_;
    }
    
    @Override
    public void run(){
        while(i>0){
            n += inc ? 1 : -1;
            i--;
        }
    }
}

