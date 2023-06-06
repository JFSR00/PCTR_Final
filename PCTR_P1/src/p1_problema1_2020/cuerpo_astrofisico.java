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
public class cuerpo_astrofisico {
    // Atributos de cuerpo_astrofisico
    protected double rad_, mass_, vol_, sup_;
    protected String name_;
    
    // Constructor de cuerpo_astrofisico
    cuerpo_astrofisico(String n, double r, double m, double v, double s){
        name_=n;
        rad_=r;
        mass_=m;
        vol_=v;
        sup_=s;
    }
    
    // Métodos modificadores
    public void setName(String n){
        name_=n;
    }
    
    public void setRad(double n){
        rad_=n;
    }
    
    public void setMass(double n){
        mass_=n;
    }
    
    public void setVolume(double n){
        vol_=n;
    }
    
    public void setSup(double n){
        sup_=n;
    }

    // Métodos observadores
    public String getName(){
        return name_;
    }
    
    public double getRad(){
        return rad_;
    }
    
    public double getMass(){
        return mass_;
    }
    
    public double getVolume(){
        return vol_;
    }
    
    public double getSup(){
        return sup_;
    }
    
    public String verDatos(){
        return "Nombre: "+name_+"\n\tRadio: "+rad_+"Km\n\tMasa: "+mass_+"Kg\n\tVolúmen: "+vol_+"Km3\n\tSuperficie: "+sup_+"Km2";
    }
}
