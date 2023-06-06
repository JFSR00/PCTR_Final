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
public class prodEscalarParalelo extends Thread {
    // Parámetros del programa
    private static int numHilos[] = {2, 4, 8, 10};
    private final static int tam = (int)Math.pow(10, 6);
    
    // Vectores y variables del programa
    private static double v1[], v2[];
    private static double productoParcial[];

    // Variables de los hilos
    private final int idHebra, inicio, fin;
    
    public prodEscalarParalelo(int idHebra, int inicio, int fin) {
        this.idHebra = idHebra;
        this.inicio = inicio;
        this.fin = fin;
    }
    
    @Override
    public void run(){
        productoParcial[idHebra] = 0;
        for(int i=inicio; i<fin; i++){
            productoParcial[idHebra] += v1[i]*v2[i];
        }
    }
    
    public static void main(String[] args) throws InterruptedException{
        // Declaración de variables
        long t1, t2;
        double res;
        int restoElem;
        
        // Declaración de vectores
        v1 = new double[tam];
        v2 = new double[tam];
        
        // Inicialización de vectores con valores aleatorios
        for(int j=0; j<tam; j++){
            v1[j]=(double)(Math.random()*10);
            v2[j]=(double)(Math.random()*10);
        }
        
        for(int n: numHilos){
            // Inicialización de variables
            res = 0;
            productoParcial = new double[n];
            restoElem = tam % n;  // Calculamos el resto de elementos por si no coincidiese una cantidad exacta de elementos por hilo
            
            // Creamos un vector de hilos
            prodEscalarParalelo hilos[] = new prodEscalarParalelo[n];
            for(int i=0; i<n; i++)
                hilos[i] = i!=(n-1)? new prodEscalarParalelo(i, i*(tam/n), (i+1)*(tam/n)) : new prodEscalarParalelo(i, i*(tam/n), (i+1)*(tam/n)+(restoElem));
            
            // Lanzamos los hilos y medimos su tiempo de ejecución
            t1=System.currentTimeMillis();
            for(prodEscalarParalelo h: hilos)
                h.start();
            for(prodEscalarParalelo h: hilos)
                h.join();
            t2=System.currentTimeMillis();
            
            // Realizamos la suma de los productos parciales
            for(int i=0; i<n; i++)
                res += productoParcial[i];
            
            // Mostramos los resultados
            System.out.println();
            System.out.println("Número de hilos: " + n);
            System.out.println("Tiempo para " + tam + " elementos: " + (t2-t1) + " ms");
            System.out.println("Resultado: " + res);
        }
    }
}
