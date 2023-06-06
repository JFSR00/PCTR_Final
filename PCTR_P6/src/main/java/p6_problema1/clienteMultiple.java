package p6_problema1;

/*Ejemplo de cliente de sockets
*@Antonio Tomeu
*@version 1.0
*/


import java.net.*;
import java.io.*;

public class clienteMultiple
{
    public static void main (String[] args)
    {
        int i = (int)(Math.random()*10);
        int puerto = 2001;
        int numClientes = 1000;
        Socket[] cables = new Socket[numClientes];
        PrintWriter[] salidas = new PrintWriter[numClientes];
        try{
            System.out.println("Realizando conexiones...");
            for(int j = 0; j<numClientes; j++){
                cables[j] = new Socket("localhost", puerto);
                salidas[j]= new PrintWriter(new BufferedWriter(new OutputStreamWriter(cables[j].getOutputStream())));
                //System.out.println("Realizada conexion a "+multiCables[j]);
            }
            System.out.println("Conexiones realizadas ");
            
            for(int j = 0; j<numClientes; j++){                
                salidas[j].println(i);
                salidas[j].flush();
            }
            
            System.out.println("Cerrando conexion...");
            for(int j = 0; j<numClientes; j++){                
                cables[j].close();
            }

        }catch (Exception e)
        {System.out.println("Error en sockets...");}
    }
}

