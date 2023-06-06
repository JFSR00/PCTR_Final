/**
 *
 * Autor: Juan Francisco Santos Relinque
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class cCuaternion {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        ICuaternion serv1 = (ICuaternion)Naming.lookup("//localhost/serv1");
        ICuaternion serv2 = (ICuaternion)Naming.lookup("//localhost/serv2");
        ICuaternion serv3 = (ICuaternion)Naming.lookup("//localhost/serv3");
        ICuaternion serv4 = (ICuaternion)Naming.lookup("//localhost/serv4");
        
        Scanner sc = new Scanner(System.in);
        
        float[] q1 = new float[4];
        float[] q2 = new float[4];
        float[] res = new float[4];
        float escalar = 0;
        
        System.out.println("Los servicios ofrecidos por el servidor son los siguientes:");
        System.out.println("\tSuma de cuaterniones");
        System.out.println("\tConjugado de cuaternion");
        System.out.println("\tEscalado de cuaternion");
        System.out.println("\tTraza de cuaternion");
        
        System.out.println("");
        
        System.out.print("Introduzca valor \"a\" del primer cuaternion: ");
        q1[0] = sc.nextFloat();
        System.out.print("Introduzca valor \"b\" del primer cuaternion: ");
        q1[1] = sc.nextFloat();
        System.out.print("Introduzca valor \"c\" del primer cuaternion: ");
        q1[2] = sc.nextFloat();
        System.out.print("Introduzca valor \"d\" del primer cuaternion: ");
        q1[3] = sc.nextFloat();
        
        System.out.print("Introduzca valor \"a\" del segundo cuaternion: ");
        q2[0] = sc.nextFloat();
        System.out.print("Introduzca valor \"b\" del segundo cuaternion: ");
        q2[1] = sc.nextFloat();
        System.out.print("Introduzca valor \"c\" del segundo cuaternion: ");
        q2[2] = sc.nextFloat();
        System.out.print("Introduzca valor \"d\" del segundo cuaternion: ");
        q2[3] = sc.nextFloat();
        
        System.out.println("");
        
        res = serv1.sumCuaternion(q1, q2);
        System.out.println("Primer cuaternion:\t"+q1[0]+" + "+q1[1]+" i + "+q1[2]+" j + "+q1[3]+" k");
        System.out.println("Segundo cuaternion:\t"+q2[0]+" + "+q2[1]+" i + "+q2[2]+" j + "+q2[3]+" k");
        System.out.println("Resultado de la suma:\t"+res[0]+" + "+res[1]+" i + "+res[2]+" j + "+res[3]+" k");
        
        res = serv2.conCuaternion(q1);
        System.out.println("Resultado de la conjugacion del primer cuaternion:\t"+res[0]+" + "+res[1]+" i + "+res[2]+" j + "+res[3]+" k");
        
        System.out.print("Introduzca valor escalar para el escalado: ");
        escalar = sc.nextFloat();
        res = serv3.xCuaternion(q1, escalar);
        System.out.println("Resultado de la escala del primer cuaternion:\t"+res[0]+" + "+res[1]+" i + "+res[2]+" j + "+res[3]+" k");
        
        System.out.println("Resultado de la traza del primer cuaternion:\t"+serv4.tCuaternion(q1));
        
        
    }
}
