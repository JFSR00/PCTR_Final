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
public class funcion1 extends funcion_abstracta {
    public double f(double n){
        return Math.sin(n);
    }
    
    public double fd(double n){
        return -Math.cos(n);
    }
}
