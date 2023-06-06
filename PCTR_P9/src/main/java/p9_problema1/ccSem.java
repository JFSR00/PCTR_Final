/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p9_problema1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Francisco Santos Relinque
 */

// Creo que está bien hecho este ejercicio, aunque no estoy seguro

public class ccSem implements Runnable{
    
    private static Semaphore sem = new Semaphore(1);

    private static double depositoCajero = 1000.0;
    
    private cuentaCorriente cuenta;
    private double cantidad;
    private boolean isDeposito;
    
    public ccSem(cuentaCorriente cuenta, double cantidad, boolean isDeposito){
        this.cuenta = cuenta;
        this.cantidad = cantidad;
        this.isDeposito = isDeposito;
    }
    
    @Override
    public void run() {
        try {
            sem.acquire();
            if(isDeposito){
                cuenta.deposito(cantidad);
                depositoCajero += cantidad;
            }else if(!isDeposito){
                cuenta.reintegro(cantidad);
                depositoCajero -= cantidad;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ccSem.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sem.release();
        }
    }
    
    public static double getDepositoCajero(){
        return depositoCajero;
    }
    
    public static void setDepositoCajero(double deposito){
        depositoCajero = deposito;
    }
    
}
