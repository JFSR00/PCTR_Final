/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_problema3;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class intDefinidaMonteCarlo {
    public static void MonteCarlo(int n, funcion_abstracta fn){
        int cont = 0;
        double x, y;
        for(int i=0; i<n; i++){
            x=Math.random();
            y=Math.random();
            if(y<=fn.f(x)){
                cont++;
            }
        }
        System.out.println("Integral aproximada: "+((double)cont/(double)n));
    }
}
