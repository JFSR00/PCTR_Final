/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_problema1_2020;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class estrella extends cuerpo_astrofisico{
    // Atributos de estrella
    protected double temp_, bright_;
    
    // Constructor de estrella
    estrella(String n, double r, double m, double v, double s, double t, double b){
        super(n,r,m,v,s);
        temp_=t;
        bright_=b;
    }
    
    // Métodos modificadores
    public void setTemp(double n){
        temp_=n;
    }
    
    public void setBright(double n){
        bright_=n;
    }
    
    // Métodos observadores
    public double getTemp(){
        return temp_;
    }
    
    public double getBright(){
        return bright_;
    }
    
    public String verDatos(){
        return super.verDatos()+"\n\tTemperatura: "+temp_+"K\n\tLuminosidad: "+bright_+"W";
    }
}
