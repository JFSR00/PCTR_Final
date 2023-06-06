//COMPILACION:javac -cp .:$MPJ_HOME/lib/mpj.jar cMat.java
//EJECUCION: mpjrun.sh -np 4 cMat

import mpi.*;
import java.util.Arrays;
public class cMat {

	public static void main(String args[]) throws Exception {
		MPI.Init(args);
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();
		int emisor = 0;
		int tag = 100;
		int unitSize = 3;

		if(rank==emisor){ //codigo del emsior
			int A[][] =
				{
					{1,2,3},
					{4,5,6},
					{7,8,9}
				};
			int B[][] =
				{
					{1,0,0},
					{0,1,0},
					{0,0,1}
				};
			int res[][] = new int[unitSize][unitSize];
			
			for(int i=1; i<4; i++){
				MPI.COMM_WORLD.Send(A, 0, unitSize, MPI.OBJECT, i, tag+i);
				if(i != 3)
					MPI.COMM_WORLD.Send(B, 0, unitSize, MPI.OBJECT, i, tag+i);
			}
			
			MPI.COMM_WORLD.Recv(res, 0, unitSize, MPI.OBJECT, 3, tag+3);
			String str = "Resultado de A traspuesta::\n";
			for(int i=0; i<unitSize; i++)
				str = str + Arrays.toString(res[i]) + "\n";
			System.out.println(str);
		}else if(rank == 1){
			int A[][] = new int[unitSize][unitSize];
			int B[][] = new int[unitSize][unitSize];
			
			MPI.COMM_WORLD.Recv(A, 0, unitSize, MPI.OBJECT, emisor, tag+rank);
			MPI.COMM_WORLD.Recv(B, 0, unitSize, MPI.OBJECT, emisor, tag+rank);
			
			for(int i=0; i<unitSize; i++)
				for(int j=0; j<unitSize; j++)
					B[i][j] += A[i][j];
			
			String str = "Resultado de A+B:\n";
			for(int i=0; i<unitSize; i++)
				str = str + Arrays.toString(B[i]) + "\n";
			System.out.println(str);
		}else if(rank == 2){
			int A[][] = new int[unitSize][unitSize];
			int B[][] = new int[unitSize][unitSize];
			int res[][] = new int[unitSize][unitSize];
			
			MPI.COMM_WORLD.Recv(A, 0, unitSize, MPI.OBJECT, emisor, tag+rank);
			MPI.COMM_WORLD.Recv(B, 0, unitSize, MPI.OBJECT, emisor, tag+rank);
			
			for(int i=0; i<unitSize; i++){
				for(int j=0; j<unitSize; j++){
					res[i][j] = 0;
					for(int k=0; k<unitSize; k++){
						res[i][j] += A[i][k]*B[k][j];
					}
				}
			}
			
			String str = "Resultado de A*B:\n";
			for(int i=0; i<unitSize; i++)
				str = str + Arrays.toString(res[i]) + "\n";
			System.out.println(str);
		}else if(rank == 3){
			int A[][] = new int[unitSize][unitSize];
			int res[][] = new int[unitSize][unitSize];
			
			MPI.COMM_WORLD.Recv(A, 0, unitSize, MPI.OBJECT, emisor, tag+rank);
			
			for(int i=0; i<unitSize; i++){
				for(int j=0; j<unitSize; j++){
					res[i][j] = A[j][i];
				}
			}
			
			MPI.COMM_WORLD.Send(res, 0, unitSize, MPI.OBJECT, emisor, tag+rank);
		}
		
		MPI.Finalize();
	}
}