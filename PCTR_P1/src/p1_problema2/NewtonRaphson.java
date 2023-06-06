/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_problema2;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class NewtonRaphson {
    public static void NewtonRaphson(double x0, int iteraciones, funcion_abstracta fn){
        double xN = x0;
        for(int i = 0; i < iteraciones; i++){
            if(fn.fd(xN) != 0){
                xN = xN - fn.f(xN)/fn.fd(xN);
                System.out.println("Iteración: "+i+" Aproximación: "+xN);
            }
        }
        System.out.println("Resultado: "+xN);
    }
}
