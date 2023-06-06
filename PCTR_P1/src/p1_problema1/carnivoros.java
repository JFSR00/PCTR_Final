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
public class carnivoros extends animal{
    
    private int animalesCazados;
    
    public carnivoros(int p, int c, String e){
	super(p, "carne", e);
	animalesCazados = c;
    }
    
    public int getAnimalesCazados(){
	return animalesCazados;
    }
    
    public void setAnimalesCazados(int c){
	animalesCazados = c;
    }
    
}
