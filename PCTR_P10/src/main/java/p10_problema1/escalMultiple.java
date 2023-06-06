//transfiere dos arrays de 4 enteros del emisor al receptor, se hace un producto interno, y se devuelve el resultado
//COMPILACION:javac -cp .;%MPJ_HOME%/lib/mpj.jar escalMultiple.java
//EJECUCION: mpjrun.sh -np 5 escalMultiple

import mpi.*;
import java.util.Arrays;
public class escalMultiple {

	public static void main(String args[]) throws Exception {
		MPI.Init(args);
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();
		int emisor = 0;
		int tag = 100; 
		int unitSize = 10;

		int bufer[] = new int[unitSize];
		if(rank==emisor){
			for(int i=0; i<unitSize; i++)
				bufer[i]=i+1;
		} 

		MPI.COMM_WORLD.Bcast(bufer, 0, unitSize, MPI.INT, emisor);

		if(rank!=emisor){ 
			for(int i=0; i<unitSize; i++)
				bufer[i]*=rank;
			
			System.out.println("Escalado por "+rank+": "+Arrays.toString(bufer));
		}
		
		MPI.Finalize();
	}
}