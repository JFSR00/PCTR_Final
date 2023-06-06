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
public class conejo extends herviboros{
    
    private String enfermedades;
    
    public conejo(String e){
	super(4, "conejo");
	enfermedades = e;
    }
    
    public String getEnfermedades(){
	return enfermedades;
    }
    
    public void setEnfermedades(String e){
	enfermedades = e;
    }
}
