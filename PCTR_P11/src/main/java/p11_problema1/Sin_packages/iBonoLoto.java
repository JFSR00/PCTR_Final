/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.*;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public interface iBonoLoto extends Remote{
    public void resetServidor() throws RemoteException;
    public boolean compApuesta(int[] apuesta) throws RemoteException;
}