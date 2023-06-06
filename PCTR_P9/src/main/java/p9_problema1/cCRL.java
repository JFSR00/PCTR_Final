/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p9_problema1;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Juan Francisco Santos Relinque
 */

// Creo que está bien hecho este ejercicio, aunque no estoy seguro

public class cCRL implements Runnable{

    private static ReentrantLock lock = new ReentrantLock();
    
    private static double depositoCajero = 1000.0;
    
    private cuentaCorriente cuenta;
    private double cantidad;
    private boolean isDeposito;
    
    public cCRL(cuentaCorriente cuenta, double cantidad, boolean isDeposito){
        this.cuenta = cuenta;
        this.cantidad = cantidad;
        this.isDeposito = isDeposito;
    }
    
    @Override
    public void run() {
        lock.lock();
        if(isDeposito){
            cuenta.deposito(cantidad);
            depositoCajero += cantidad;
        }else if(!isDeposito){
            cuenta.reintegro(cantidad);
            depositoCajero -= cantidad;
        }
        lock.unlock();
    }
    
    public static double getDepositoCajero(){
        return depositoCajero;
    }
    
    public static void setDepositoCajero(double deposito){
        depositoCajero = deposito;
    }
    
}
