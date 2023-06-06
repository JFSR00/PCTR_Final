//transfiere dos arrays de 4 enteros del emisor al receptor, se hace un producto interno, y se devuelve el resultado
//COMPILACION:javac -cp .;%MPJ_HOME%/lib/mpj.jar prodInterno.java
//EJECUCION: mpjrun.sh -np 2 prodInterno

import mpi.*;
import java.util.Arrays;
public class prodInterno {

	public static void main(String args[]) throws Exception {
		MPI.Init(args);
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();
		int emisor = 0;
		int receptor = 1;
		int tag = 100;
		int unitSize = 4;

		if(rank==emisor){ //codigo del emsior
			int v1[] = {1,2,3,4};
			int v2[] = {1,2,3,4};
			int res[] = new int[unitSize];
			
			
			MPI.COMM_WORLD.Send(v1, 0, unitSize, MPI.INT, receptor, tag);
			MPI.COMM_WORLD.Send(v2, 0, unitSize, MPI.INT, receptor, tag);
			
			MPI.COMM_WORLD.Recv(res, 0, unitSize, MPI.INT, receptor, tag);
			System.out.println("Producto Interno: "+Arrays.toString(res));
		}else{ //codigo del receptor
			int rv1[] = new int[unitSize];
			int rv2[] = new int[unitSize];
			
			MPI.COMM_WORLD.Recv(rv1, 0, unitSize, MPI.INT, emisor, tag);
			MPI.COMM_WORLD.Recv(rv2, 0, unitSize, MPI.INT, emisor, tag);
			System.out.println("Vector 1: "+Arrays.toString(rv1));
			System.out.println("Vector 2: "+Arrays.toString(rv2));
			
			for(int i=0; i<unitSize; i++)
				rv2[i] *= rv1[i];
			
			MPI.COMM_WORLD.Send(rv2, 0, unitSize, MPI.INT, emisor, tag);
		}
		
		MPI.Finalize();
	}
}