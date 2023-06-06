/*
4. Escriba en cuentaCorrienta.java una clase que modele una cuenta corriente.
Incorpore al menos los atributos numero de cuenta y saldo, y los metodos
deposito y reintegro. Simule ahora, utilizando hilos mediante tareas por implementacion
de la interfaz Runnable a una red de cajeros automaticos, donde cada
cajero (guardar en fichero cajero.java) realiza una operacion de ingreso o de
reintegro sobre un cuenta corriente. Provoque ahora una condicion de concurso
de los hilos contra una instancia de la clase anterior, de forma que la suma neta
de las operaciones de todos ellos sea igual a 0. En esta situacion, el saldo inicial
de la cuenta deberia haber permanecido constante. Compruebe que no tiene por
que ser asi. Guarde la clase que crea y simula a los cajeros en redCajeros.java.
 */
package p9_problema1;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class cuentaCorriente {
    public String nCuenta;
    public double saldo;
    
    public cuentaCorriente(String nCuenta, double saldo){
        this.nCuenta = nCuenta;
        this.saldo = saldo;
    }
    
    public double deposito(double dep){
        return saldo+=dep;
    }
    
    public double reintegro(double ret){
        return saldo-=ret;
    }
    
    public String getnCuenta() {
        return nCuenta;
    }

    public double getSaldo() {
        return saldo;
    }
}
