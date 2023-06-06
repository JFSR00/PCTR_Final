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
public class cuerpo_planetario extends cuerpo_astrofisico {
    // Atributos de cuerpo_planetario
    private estrella orbit_;
    
    // Constructor de cuerpo_planetario
    cuerpo_planetario(String n, double r, double m, double v, double s, estrella o){
        super(n,r,m,v,s);
        orbit_=o;
    }
    
    // Métodos modificadores
    public void setOrbit(estrella n){
        orbit_=n;
    }
    
    // Métodos observadores
    public estrella getOrbit(){
        return orbit_;
    }
    
    public String verDatos(){
        return super.verDatos()+"\n\tOrbita: "+orbit_.getName();
    }
}
