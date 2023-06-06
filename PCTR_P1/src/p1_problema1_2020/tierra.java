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
public class tierra extends cuerpo_planetario{
    tierra(){
        super("Tierra", 6371, 5.9736e24, 1.08321e12, 510072000, new sol());
        // Unidades de medida en orden: --, Km, Kg, Km^3, Km^2, --
    }
}
