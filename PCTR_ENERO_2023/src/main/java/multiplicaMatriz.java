/**
 *
 * Autor: Juan Francisco Santos Relinque
 */
//COMPILACION: javac -cp .;%MPJ_HOME%/lib/mpj.jar multiplicaMatriz.java
//EJECUCION: mpjrun.bat -np 3 multiplicaMatriz

import mpi.*;

public class multiplicaMatriz {
    public static void main(String[] args) {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        int master = 0;
        int tag = 100; 
        
        int unitSize = 1;
        int totalMSize = 9;
        int mSize = 3;
        int vSize = 3;
        
        int []totalM = new int[totalMSize];
        int []M = new int[mSize];
        int []v = new int[vSize];
        int []res = new int[unitSize];
        
        if(rank==master){
            totalM = new int[]{0,2,4,6,8,10,12,14,16};
            v = new int[]{1,1,1};
        }
        MPI.COMM_WORLD.Scatter(totalM, 0, mSize, MPI.INT, M, 0, mSize, MPI.INT, master);
        MPI.COMM_WORLD.Bcast(v, 0, vSize, MPI.INT, master);
        
        for(int i=0; i<vSize; i++){
            res[0] += M[i]*v[i];
        }
        
        if(rank==master){
            int aux = res[0];
            res = new int[3];
            res[0] = aux;
            for(int i=master+1; i<size; i++){
                MPI.COMM_WORLD.Recv(res, i, unitSize, MPI.INT, i, tag);
            }
            System.out.println("Vector producto resultante: ["+res[0]+", "+res[1]+", "+res[2]+"]");
        }else{
            MPI.COMM_WORLD.Send(res, 0, unitSize, MPI.INT, master, tag);
        }
        
        MPI.Finalize();
    }
}
