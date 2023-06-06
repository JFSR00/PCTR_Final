/*
3. Se desea realizar el escalado de un vector de numeros enteros de 10^6
componentes. Escriba un programa secuencial escalaVector.java que haga
el trabajo. Ahora, escriba una nueva version paralela multihebrada y llamela
escalaVPar.java. Escriba un documento que incluya una tabla de analisis
tablaCPU.java que debera recoger de forma aproximada los picos de uso maximo
de la CPU como una funcion del tama~no del vector (10^6; 2 × 10^6; 3 × 10^6...)
y del tipo de procesamiento empleado.
 */
package p2_problema3;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class escalaVector {
    public static int vector[];
    
    public static void main(String[] args){
        long t1, t2;
        vector = new int[150*(int)Math.pow(10, 6)];        
        for(int i=10; i<=150; i+=10){
            for(int j=0; j<vector.length; j++)
                vector[j]=j;
            t1=System.currentTimeMillis();
            escalado(vector, 2, i*(int)Math.pow(10, 6));
            t2=System.currentTimeMillis();
            System.out.println("Tiempo para tamaño " + i + "*10^6: " + (t2-t1));
        }
    }
    
    public static int[] escalado(int[] v, int x, int tam){
        for(int i=0; i<tam; i++){
            v[i]*=x;
        }
        return v;
    }
}
