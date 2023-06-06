/**
 *
 * Autor: Juan Francisco Santos Relinque
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class sCuaternion extends UnicastRemoteObject implements ICuaternion{
    
    public sCuaternion() throws Exception {}

    // Suma: si q1 = a1 + b1i + c1j + d1k y q2 = a2 + b2i + c2j + d2k, entonces q1 + q2 = (a1 + a2) + (b1 + b2)i + (c1 + c2)j + (d1 + d2)k
    @Override
    public float[] sumCuaternion(float[] q1, float[] q2) throws RemoteException {
        float[] res;
        if(q1.length == q2.length && q1.length == 4){
            res = new float[q1.length];
            
            for(int i=0; i<res.length; i++)
                res[i] = q1[i] + q2[i];
            
        }else{
            throw new RemoteException("Parametros pasados no son cuaterniones");
        }
        return res;
    }

    // Conjugado: si q = a + bi + cj + dk, entonces qc = a − bi − cj − dk
    @Override
    public float[] conCuaternion(float[] q) throws RemoteException {
        float[] res;
        if(q.length == 4){
            res = new float[q.length];
            
            res[0] = q[0];
            for(int i=1; i<res.length; i++)
                res[i] = -q[i];
            
        }else{
            throw new RemoteException("Parametros pasados no son cuaterniones");
        }
        return res;
    }

    // Escalado: si q = a + bi + cj + dk y p ∈ R, entonces p · q = (p · a) + (p · b)i + (p · c)j + (p · d)k
    @Override
    public float[] xCuaternion(float[] q, float p) throws RemoteException {
        float[] res;
        if(q.length == 4){
            res = new float[q.length];
            
            for(int i=0; i<res.length; i++)
                res[i] = p*q[i];
            
        }else{
            throw new RemoteException("Parametros pasados no son cuaterniones");
        }
        return res;
    }

    // Traza: si q = a + bi + cj + dk, entonces traza(q) = a + b + c + d
    @Override
    public float tCuaternion(float[] q) throws RemoteException {
        float res = 0;
        if(q.length == 4){
            for(int i=0; i<q.length; i++)
                res += q[i];
            
        }else{
            throw new RemoteException("Parametros pasados no son cuaterniones");
        }
        return res;
    }
    
    public static void main(String[] args) throws RemoteException, MalformedURLException, Exception {
        sCuaternion serv1 = new sCuaternion();
        sCuaternion serv2 = new sCuaternion();
        sCuaternion serv3 = new sCuaternion();
        sCuaternion serv4 = new sCuaternion();
        
        Naming.rebind("serv1", serv1);
        Naming.rebind("serv2", serv2);
        Naming.rebind("serv3", serv3);
        Naming.rebind("serv4", serv4);
        
        System.out.println("Servidor remoto preparado");
    }
    
}
