package p2_problema3;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class escalaVPar extends Thread{
    public static int vector[];

    public int ini, fin;
    public int escalar = 10;
    
    public escalaVPar(int ini, int fin){
        this.ini = ini;
        this.fin = fin;
    }
    
    @Override
    public void run(){
        for(int i=ini; i<fin; i++){
            vector[i]*=escalar;
        }
    }
    
    public static void initVector(int tam){
        vector = new int[tam];
        for(int i=0; i<tam; i++){
            vector[i]=i;
        }
    }
    
    public static int vectorLentgth(){
        return vector.length;
    }
    
    public void setIniFin(int ini, int fin){
        this.ini = ini;
        this.fin = fin;
    }
    
    
    public static void main(String[] args) throws Exception{
        long t1, t2;
        int avaibleThreads = Runtime.getRuntime().availableProcessors();
        int tamVentana = 0;
        escalaVPar hilos[] = new escalaVPar[avaibleThreads];
        
        for(int i=10; i<=150; i+=10){
            escalaVPar.initVector(i*(int)Math.pow(10, 6));
            tamVentana = escalaVPar.vectorLentgth()/avaibleThreads;
            t1=System.currentTimeMillis();
            for(int j = 0; j < avaibleThreads; j++){
                hilos[j] = new escalaVPar(j * tamVentana, (j+1) * tamVentana);
                hilos[j].start();
            }
            for(int j = 0; j < avaibleThreads; j++)
                hilos[j].join();
            
            t2=System.currentTimeMillis();
            System.out.println("Tiempo para tamaño " + i + "*10^6: " + (t2-t1));
        }
    }
}