/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p9_problema1;

/**
 *
 * @author Juan Francisco Santos Relinque
 */

// Creo que está bien hecho este ejercicio, aunque no estoy seguro

public class redCajeros {
    public static void main(String[] args) throws InterruptedException {
        cajero.setDepositoCajero(1000.0);
        
        cuentaCorriente c1 = new cuentaCorriente("0001", 542.75);
        cuentaCorriente c2 = new cuentaCorriente("0002", 1426.58);
        cuentaCorriente c3 = new cuentaCorriente("0003", 74.0);
        cuentaCorriente c4 = new cuentaCorriente("0004", 5004924.99);
        /*
        Thread h0 = new Thread(new cajero(c1, 500.0, false));
        Thread h1 = new Thread(new cajero(c2, 250.0, false));
        Thread h2 = new Thread(new cajero(c3, 750.0, true));
        Thread h3 = new Thread(new cajero(c4, 1000.0, false));
        Thread h4 = new Thread(new cajero(c1, 500.0, false));
        Thread h5 = new Thread(new cajero(c2, 250.0, false));
        Thread h6 = new Thread(new cajero(c3, 1750.0, true));
        Thread h7 = new Thread(new cajero(c4, 1000.0, false));
        */
        /*
        Thread h0 = new Thread(new cCRL(c1, 500.0, false));
        Thread h1 = new Thread(new cCRL(c2, 250.0, false));
        Thread h2 = new Thread(new cCRL(c3, 750.0, true));
        Thread h3 = new Thread(new cCRL(c4, 1000.0, false));
        Thread h4 = new Thread(new cCRL(c1, 500.0, false));
        Thread h5 = new Thread(new cCRL(c2, 250.0, false));
        Thread h6 = new Thread(new cCRL(c3, 1750.0, true));
        Thread h7 = new Thread(new cCRL(c4, 1000.0, false));
        */
        
        Thread h0 = new Thread(new ccSem(c1, 500.0, false));
        Thread h1 = new Thread(new ccSem(c2, 250.0, false));
        Thread h2 = new Thread(new ccSem(c3, 750.0, true));
        Thread h3 = new Thread(new ccSem(c4, 1000.0, false));
        Thread h4 = new Thread(new ccSem(c1, 500.0, false));
        Thread h5 = new Thread(new ccSem(c2, 250.0, false));
        Thread h6 = new Thread(new ccSem(c3, 1750.0, true));
        Thread h7 = new Thread(new ccSem(c4, 1000.0, false));
        
        
        h0.start();
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        h6.start();
        h7.start();
        
        h0.join();
        h1.join();
        h2.join();
        h3.join();
        h4.join();
        h5.join();
        h6.join();
        h7.join();
        
        System.out.println("Saldo cajero: " + cajero.getDepositoCajero() + "€");
        System.out.println("-------------------------");
        System.out.println("Saldo cuenta " + c1.getnCuenta() + ": " + c1.getSaldo() + "€");
        System.out.println("Saldo cuenta " + c2.getnCuenta() + ": " + c2.getSaldo() + "€");
        System.out.println("Saldo cuenta " + c3.getnCuenta() + ": " + c3.getSaldo() + "€");
        System.out.println("Saldo cuenta " + c4.getnCuenta() + ": " + c4.getSaldo() + "€");
        
    }
}
