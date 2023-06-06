/*
1. Queremos efectuar el producto escalar de dos vectores reales de 106 componentes.
Comience por escribir un programa secuencial que desarrolle el c´alculo
y gu´ardelo en prodEscalar.java. Ahora escriba un programa que efect´ue el
c´alculo de forma paralela, utilizando divisi´on manual de los datos. Para ello,
escriba una clase prodEscalarParalelo.java que modele a las hebras mediante
herencia de la clase Thread. El constructor de clase podr´ıa ser similar a la
siguiente:
public prodEscalarParalelo(int idHebra, int inicio, inf final)
donde los par´ametros del constructor le indican a cade hebra cu´al es su identificador
(un n´umero distinto para cada hebra, asignado desde el programa principal),
y d´onde comienzan y terminan los subvectores de datos que les corresponde
procesar. El resultado de ese procesamiento ser´a almacenado por cada hebra en
una ranura productoParcial[idHebra] de un array com´un a todas hebras. El
programa principal crear´a y lanzar´a concurrentemente las hebras, esperar´a a
que concluyan, y sumar´a todas las ranuras del vector productoParcial para
obtener el resultado final. Tome tiempos para el programa secuencial, y para
el programa paralelo con un n´umero de hebras igual a 2, 4, 8, 10 y escriba sus
resultados en formato tabular, en el documento tiemposProdEscalar.pdf
 */
package p3_problema1;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class prodEscalar {
    public static double v1[], v2[];
    
    public static void main(String[] args){
        long t1, t2;
        double res;
        v1 = new double[(int)Math.pow(10, 6)];
        v2 = new double[(int)Math.pow(10, 6)];
        for(int j=0; j<v1.length; j++){
            v1[j]=(double)j;
            v2[j]=(double)j+1;
        }
        t1=System.currentTimeMillis();
        res = productoEscalar(v1, v2);
        t2=System.currentTimeMillis();
        System.out.println("Tiempo para tamaño 10^6: " + (t2-t1) + " ms");
        System.out.println("Resultado: " + res);
    }
    
    public static double productoEscalar(double[] v1, double[] v2){
        double res = 0;
        for(int i=0; i<v1.length; i++){
            res += v1[i]*v2[i];
        }
        return res;
    }
}
