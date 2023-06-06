/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_problema1;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class hombre extends omnivoros{
    
    private String nombre, sexo;
    
    public hombre(String n, String s){
	super(2, "hombre");
	nombre = n;
	sexo = s;
    }
    
    public String getNombre(){
	return nombre;
    }
    
    public String getSexo(){
	return sexo;
    }
    
}
