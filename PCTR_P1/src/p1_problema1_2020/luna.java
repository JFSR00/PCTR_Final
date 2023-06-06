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
public class luna extends satelite{
    luna(){
        super("Luna", 1737.1, 7.349e22, 2.1958e10, 38e6, new tierra());
        // Unidades de medida en orden: --, Km, Kg, Km^3, Km^2, --
    }
}
