/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p6_problema3;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class heterogenea {
    private int n, m;
    
    public heterogenea(){
        this(0,0);
    }
    
    public heterogenea(int n, int m){
        this.n = n;
        this.m = m;
    }
    
    public synchronized void incN(int i){
        n+=i;
    }
    
    public void incM(int i){
        m+=i;
    }
    
    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }
}
