/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_problema4;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class cajero implements Runnable{

    private static double depositoCajero = 1000.0;
    
    private cuentaCorriente cuenta;
    private double cantidad;
    private boolean isDeposito;
    
    public cajero(cuentaCorriente cuenta, double cantidad, boolean isDeposito){
        this.cuenta = cuenta;
        this.cantidad = cantidad;
        this.isDeposito = isDeposito;
    }
    
    @Override
    public void run() {
        if(isDeposito){
            cuenta.deposito(cantidad);
            depositoCajero += cantidad;
        }else if(!isDeposito){
            cuenta.reintegro(cantidad);
            depositoCajero -= cantidad;
        }
    }
    
    public static double getDepositoCajero(){
        return depositoCajero;
    }
    
    public static void setDepositoCajero(double deposito){
        depositoCajero = deposito;
    }
    
}
