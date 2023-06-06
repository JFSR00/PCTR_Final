/**
 *
 * Autor: Juan Francisco Santos Relinque
 */
//COMPILACION:javac -cp .;%MPJ_HOME%/lib/mpj.jar tokenRing.java
//EJECUCION: mpjrun.bat -np 10 tokenRing

import mpi.*;

public class tokenRing {
    public static void main(String[] args) {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        int master = 0;
        int tag = 100; 
        int unitSize = 1;
        int token[] = {10};
        int numRecv = 0;

        if(rank==master){
            while(numRec < 2){
                System.out.println("Soy el proceso "+rank+" y el token vale: "+token[0]);
                MPI.COMM_WORLD.Send(token, 0, unitSize, MPI.INT, rank+1, tag);
                MPI.COMM_WORLD.Recv(token, 0, unitSize, MPI.INT, size-1, tag);
                token[0] = token[0] + 1;
                numRecv++;
            }
        }else{
            while(numRecv < 2){
                MPI.COMM_WORLD.Recv(token, 0, unitSize, MPI.INT, rank-1, tag);
                token[0] = token[0] + 1;
                numRecv++;
                System.out.println("Soy el proceso "+rank+" y el token vale: "+token[0]);
                MPI.COMM_WORLD.Send(token, 0, unitSize, MPI.INT, (rank+1)%size, tag);
            }
        }
        MPI.Finalize();
    }
}
