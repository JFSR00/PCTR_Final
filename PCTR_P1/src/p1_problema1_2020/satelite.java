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
public class satelite extends cuerpo_astrofisico{
    // Atributos de cuerpo_planetario
    private cuerpo_planetario orbit_;
    
    // Constructor de cuerpo_planetario
    satelite(String n, double r, double m, double v, double s, cuerpo_planetario o){
        super(n,r,m,v,s);
        orbit_=o;
    }
    
    // Métodos modificadores
    public void setOrbit(cuerpo_planetario n){
        orbit_=n;
    }
    
    // Métodos observadores
    public cuerpo_planetario getOrbit(){
        return orbit_;
    }
    
    public String verDatos(){
        return super.verDatos()+"\n\tOrbita: "+orbit_.getName();
    }
}
