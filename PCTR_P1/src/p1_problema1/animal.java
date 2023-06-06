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
public class animal {
    private int nPatas;
    private final String alimentacion, especie;
    
    public animal(int p, String a, String e){
	nPatas = p;
	alimentacion = a;
	especie = e;
    }
    
    public int getNumPatas(){
	return nPatas;
    }
    
    public void setNumPatas(int p){
	nPatas = p;
    }
    
    public String getAlimentacion(){
	return alimentacion;
    }
    
    public String getEspecie(){
	return especie;
    }
}
