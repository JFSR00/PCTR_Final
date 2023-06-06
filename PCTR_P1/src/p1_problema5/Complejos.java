/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_problema5;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class Complejos {
    private final double[] complex;

    public Complejos(double r, double i) {
        complex = new double[]{r, i};
    }
    
    public Complejos(double[] complex) {
        this.complex = complex;
    }
    
    public double getReal(){
        return complex[0];
    }
    
    public double getImaginario(){
        return complex[1];
    }
    
    public void setReal(double n){
        complex[0] = n;
    }
    
    public void setImaginario(double n){
        complex[1] = n;
    }
    
    public static Complejos suma(Complejos a, Complejos b){
        return new Complejos(a.getReal()+b.getReal(), a.getImaginario()+b.getImaginario());
    }
    
    public static Complejos resta(Complejos a, Complejos b){
        return new Complejos(a.getReal()-b.getReal(), a.getImaginario()-b.getImaginario());
    }
    
    public static Complejos producto(Complejos a, Complejos b){
        return new Complejos(a.getReal()*b.getReal() - a.getImaginario()*b.getImaginario(), a.getReal()*b.getImaginario() + b.getReal()*a.getImaginario());
    }
    
    public static Complejos cociente(Complejos a, Complejos b){
        return new Complejos(
                (a.getReal()*b.getReal() + a.getImaginario()*b.getImaginario())/(Math.pow(b.getReal(), 2) + Math.pow(b.getImaginario(), 2)),
                (b.getReal()*a.getImaginario() - a.getReal()*b.getImaginario())/(Math.pow(b.getReal(), 2) + Math.pow(b.getImaginario(), 2))
        );
    }
    
    public static double modulo(Complejos a){
        return Math.sqrt(Math.pow(a.getReal(), 2) + Math.pow(a.getImaginario(), 2));
    }
}
/*
suma, resta, modulo, producto y cociente
*/