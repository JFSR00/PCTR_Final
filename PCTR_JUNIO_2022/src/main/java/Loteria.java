/**
 *
 * Autor: Juan Francisco Santos Relinque
 */
//COMPILACION:javac -cp .;%MPJ_HOME%/lib/mpj.jar Loteria.java
//EJECUCION: mpjrun.bat -np 5 Loteria

import mpi.*;
import java.util.Random;

public class Loteria {
    public static void main(String[] args) {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        int master = 0;
        int tag = 100; 
        int unitSize = 1;

        if(rank==master){
            Random rand = new Random(System.nanoTime());
            int numSecreto = rand.nextInt(100);
            int ganador[] = {0};
            int respuesta[] = {0};
            System.out.println("Número secreto: "+numSecreto);
            
            while(ganador[0] == 0){
                for(int i=1; i<size; i++){
                    MPI.COMM_WORLD.Send(ganador, 0, unitSize, MPI.INT, i, tag);
                }
                for(int i=1; i<size; i++){
                    MPI.COMM_WORLD.Recv(respuesta, 0, unitSize, MPI.INT, i, tag);
                    System.out.println("Proceso "+i+" juega con el número "+respuesta[0]);
                    if(respuesta[0] == numSecreto && ganador[0] == 0){
                        ganador[0] = i;
                    }else if(respuesta[0] == numSecreto && ganador[0] != 0 && rand.nextBoolean()){ // Es por si hay algun otro ganador
                        ganador[0] = i;
                    }
                }
            }
            
            for(int i=1; i<size; i++){
                MPI.COMM_WORLD.Send(ganador, 0, unitSize, MPI.INT, i, tag);
            }

            System.out.println("El proceso "+ganador[0]+" gana el juego");
        }else{
            Random rand = new Random(System.nanoTime());
            int ganador[] = {0};
            int respuesta[] = {0};
            while(ganador[0] == 0){
                MPI.COMM_WORLD.Recv(ganador, 0, unitSize, MPI.INT, master, tag);
                if(ganador[0] == 0){
                    respuesta[0] = rand.nextInt(100);
                    MPI.COMM_WORLD.Send(respuesta, 0, unitSize, MPI.INT, master, tag);
                }
            }
            
        }
        MPI.Finalize();
    }
}
