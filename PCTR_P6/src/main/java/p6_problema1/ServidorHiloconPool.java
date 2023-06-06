package p6_problema1;

import java.net.*;
import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ServidorHiloconPool implements Runnable{
    private Socket enchufe;
    
    public ServidorHiloconPool(Socket s){enchufe = s;}

    public void run(){
        try{
            BufferedReader entrada = new BufferedReader(new InputStreamReader(enchufe.getInputStream()));
            String datos = entrada.readLine();
            int j;
            int i = Integer.valueOf(datos).intValue();
            for(j=1; j<=1; j++){
                System.out.println("El cliente "+enchufe.getInetAddress().getHostAddress()+" en el puerto "+enchufe.getPort()+" escribiendo el dato "+i);
                Thread.sleep(500);
            }
            enchufe.close();
            System.out.println("El cliente "+enchufe.getInetAddress().getHostAddress()+" en el puerto "+enchufe.getPort()+" cierra su conexion...");
        } catch(Exception e){System.out.println("Error...");}
    }

    public static void main (String[] args){
        int puerto = 2001;
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2000);
            try{
                ServerSocket chuff = new ServerSocket (puerto, 3000);

                while (true){
                    System.out.println("Esperando solicitud de conexion...");
                    Socket cable = chuff.accept();
                    System.out.println("Recibida solicitud de conexion...");
                    executor.execute(new ServidorHiloconPool(cable));
                }
          } catch (Exception e){System.out.println("Error en sockets...");}
    }

}

