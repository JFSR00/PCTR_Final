/*
5. Deseamos conocer la rapidez en tiempo de las siguientes t´ecnicas de control
de exclusi´on mutua en java: cerrojos synchronized, sem´aforos de clase
Semaphore, cerrojos de clase ReentrantLock, y objetos atomic. Escriba segmentos
de c´odigo con una estructura similar a la siguiente:

public long f(long iter){
ini=activar-cronometro;
for(long i=0; i<iter; i++){
pre-protocolo;
n++; //seccion critica
post-protocolo;
}
fin=parar-cronometro;
return(fin-ini);
}

Los protocolos de acceso y salida pre y post de la secci´on cr´ıtica los construir´a
a partir de la plantilla anterior, implement´andolos con las t´ecnicas ya citadas,
y har´a pruebas con un n´umero creciente de iteraciones con cada t´ecnica de
control de exclusi´on mutua. Guarde el c´odigo en tiempos.java. Tome ahora
tiempos y construya una gr´afica que incluya las curvas de tiempo para cada
t´ecnica de control como una funci´on del n´umero de iteraciones. Esa curva le
dir´a, previsiblemente, que t´ecnica es m´as r´apida. Gu´ardela en curva.pdf.
 */
package p9_problema5;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class tiempos {
    private Object lock = new Object();
    private Semaphore sem = new Semaphore(1);
    private ReentrantLock rLock = new ReentrantLock();
    
    public long fSynchronized(long iter){
        long ini=System.nanoTime();
        long n=0;
        for(long i=0; i<iter; i++){
            synchronized(lock){
                n++; //seccion critica
            }
        }
        long fin=System.nanoTime();
        return(fin-ini);
    }
    
    public long fSemaphore(long iter){
        long ini=System.nanoTime();
        long n=0;
        for(long i=0; i<iter; i++){
            try {
                sem.acquire();
                n++; //seccion critica
            } catch (InterruptedException ex) {
                Logger.getLogger(tiempos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                sem.release();
            }
        }
        long fin=System.nanoTime();
        return(fin-ini);
    }
    
    public long fReentrantLock(long iter){
        long ini=System.nanoTime();
        long n=0;
        for(long i=0; i<iter; i++){
            rLock.lock();
            n++; //seccion critica
            rLock.unlock();
        }
        long fin=System.nanoTime();
        return(fin-ini);
    }
    
    public static void main(String[] args) {
        long BEGIN = 1000;
        long STEP = 1000;
        long END = 10000;
        
        long N_MEDIA = 100;
        
        tiempos t = new tiempos();
        
        long mSynchronized = 0;
        long mSemaphore = 0;
        long mReentrantLock = 0;
        
        for(long i=BEGIN; i<=END; i+=STEP){
            mSynchronized = 0;
            mSemaphore = 0;
            mReentrantLock = 0;
            for(int j=0; j<N_MEDIA; j++){
                mSynchronized += t.fSynchronized(i);
                mSemaphore += t.fSemaphore(i);
                mReentrantLock += t.fReentrantLock(i);
            }
            mSynchronized /= N_MEDIA;
            mSemaphore /= N_MEDIA;
            mReentrantLock /= N_MEDIA;
            
            System.out.println("Synchronized ("+i+" it): "+mSynchronized+" ns");
            System.out.println("Semaphore ("+i+" it): "+mSemaphore+" ns");
            System.out.println("ReetrantLock ("+i+" it): "+mReentrantLock+" ns");
            System.out.println();
            
        }
    }
}
