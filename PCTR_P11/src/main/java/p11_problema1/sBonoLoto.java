/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p11_problema1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class sBonoLoto extends UnicastRemoteObject implements iBonoLoto {

    private Random bombo = new Random();
    private int combinacion[] = new int[6];
    
    private Object lock = new Object();
    
    public sBonoLoto() throws Exception {}
    
//    @Override
    public void resetServidor() throws RemoteException {
        synchronized(lock){
            System.out.println("Combinación: ");
            for(int i=0; i<combinacion.length; i++){
                combinacion[i] = bombo.nextInt(49) + 1;
                System.out.print(combinacion[i]+" ");
            }
            System.out.println("");
        }
    }

//    @Override
    public boolean compApuesta(int[] apuesta) throws RemoteException {
        boolean res = false;
        synchronized(lock){
            res = true;
            for(int i=0; i<combinacion.length && res; i++)
                if(apuesta[i] != combinacion[i])
                    res = false;
        }
        return res;
    }
    
    public static void main(String[] args) throws RemoteException, MalformedURLException, Exception {
        sBonoLoto servidor = new sBonoLoto();
        Naming.rebind("bonoloto", servidor);
        servidor.resetServidor();
        System.out.println("Servidor remoto preparado");
    }
    
}
