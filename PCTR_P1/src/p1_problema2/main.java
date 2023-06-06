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
public class main {
    public static void main(String[] args){
        funcion1 f1 = new funcion1();
        funcion2 f2 = new funcion2();
        
        NewtonRaphson.NewtonRaphson(0.5, 6, f1);
        NewtonRaphson.NewtonRaphson(2.5, 6, f2);
    }
}
