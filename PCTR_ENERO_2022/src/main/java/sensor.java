/**
 *
 * Autor: Juan Francisco Santos Relinque
 */

import java.util.Random;
import java.util.Scanner;

public class sensor extends Thread{
    
    int[] senalEntradaZeta, senalEntradaRho, senalSalidaXi;
    int ini, fin, n;
    
    public sensor(int[] senalEntradaZeta, int[] senalEntradaRho, int[] senalSalidaXi, int n, int ini, int fin){
        this.senalEntradaZeta = senalEntradaZeta;
        this.senalEntradaRho = senalEntradaRho;
        this.senalSalidaXi = senalSalidaXi;
        this.n = n;
        this.ini = ini;
        this.fin = fin;
    }
    
    @Override
    public void run(){
        for(int i=ini; i<fin; i++){
            // Hago uso del operador ternario para los casos de las fronteras, pues simplifica el código
            senalSalidaXi[i]= (senalEntradaZeta[i]+(i+1 == n? 0 : senalEntradaZeta[i+1])) + (senalEntradaRho[i]+(i == 0? 0 : senalEntradaRho[i-1]));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Random generador = new Random();
        Thread[] hebras;
        Thread secuencial;
        long secBegin, secEnd, parBegin, parEnd;
        
        int[] senalEntradaZeta, senalEntradaRho, senalSalidaXi;
        int n, opc, nHebras, eltosHebra, ini, fin;
        
        do{
            System.out.println("Modos de ejecucion:");
            System.out.println("\t1. Manual");
            System.out.println("\t2. Automatico");
            System.out.println("");
            System.out.print("Opcion: ");
            opc = sc.nextInt();
        }while(opc < 1 || opc > 2);
        
        if(opc == 1){                   // Modo Manual
            System.out.println("");
            System.out.print("Introduzca tamano de senales: ");
            n = sc.nextInt();
            
            senalEntradaZeta = new int[n];
            senalEntradaRho = new int[n];
            senalSalidaXi = new int[n];
            
            System.out.println("");
            for(int i=0; i<n; i++){
                do{
                    System.out.print("Introduzca senal "+i+" de Zeta: ");
                    senalEntradaZeta[i] = sc.nextInt();
                }while(senalEntradaZeta[i]<0 || senalEntradaZeta[i]>5);
                do{
                    System.out.print("Introduzca senal "+i+" de Rho: ");
                    senalEntradaRho[i] = sc.nextInt();
                }while(senalEntradaZeta[i]<0 || senalEntradaZeta[i]>5);
            }
            
            System.out.println("");
            do{
                System.out.print("Introduzca numero de hebras que desee usar: ");
                nHebras = sc.nextInt();
            }while(nHebras > n);    // De esta forma nos aseguramos de que al menos hay un elemento por hebra
            
            hebras = new Thread[nHebras];
            eltosHebra = n/nHebras;
            
            ini=0;
            fin=eltosHebra;
            
            for(int i=0; i<nHebras; i++){
                hebras[i] = new sensor(senalEntradaZeta, senalEntradaRho, senalSalidaXi, n, ini, fin);
                hebras[i].start();
                ini = fin;
                fin = i+1 == nHebras-1? n : fin + eltosHebra; // De esta forma nos aseguramos de que no quedan elementos sin procesar
            }
            
            for(int i=0; i<nHebras; i++){
                hebras[i].join();
            }
            
            System.out.println("");
            System.out.print("Zeta:\t");
            for(int i=0; i<n; i++)
                System.out.print(" "+senalEntradaZeta[i]);
            
            System.out.println("");
            System.out.print("Rho:\t");
            for(int i=0; i<n; i++)
                System.out.print(" "+senalEntradaRho[i]);
            
            System.out.println("");
            System.out.print("Xi:\t");
            for(int i=0; i<n; i++)
                System.out.print(" "+senalSalidaXi[i]);
            
        }else{                  // Modo Automatico
            n = (int) Math.pow(10, 7);
            senalEntradaZeta = new int[n];
            senalEntradaRho = new int[n];
            senalSalidaXi = new int[n];
            
            for(int i=0; i<n; i++){ // Generacion de senales aleatorias
                senalEntradaZeta[i] = generador.nextInt(6);
                senalEntradaRho[i] = generador.nextInt(6);
            }
            
            nHebras = Runtime.getRuntime().availableProcessors();
            hebras = new Thread[nHebras];
            eltosHebra = n/nHebras;
            
            ini=0;
            fin=eltosHebra;
            
            for(int i=0; i<nHebras; i++){
                hebras[i] = new sensor(senalEntradaZeta, senalEntradaRho, senalSalidaXi, n, ini, fin);
                ini = fin;
                fin = i+1 == nHebras-1? n : fin + eltosHebra; // De esta forma nos aseguramos de que no quedan elementos sin procesar
            }
            
            
            // Para la medicion en paralelo hago uso de un solo hilo que abarque todo el array
            secuencial = new sensor(senalEntradaZeta, senalEntradaRho, senalSalidaXi, n, 0, n);
            secBegin = System.nanoTime();
            secuencial.start();
            secuencial.join();
            secEnd = System.nanoTime();
            
            senalSalidaXi = new int[n];     // Limpiamos el array de salida para nueva medicion
            
            parBegin = System.nanoTime();
            for(int i=0; i<nHebras; i++){
                hebras[i].start();
            }
            for(int i=0; i<nHebras; i++){
                hebras[i].join();
            }
            parEnd = System.nanoTime();
            
            System.out.println("Tiempo de ejecucion secuencial: "+(secEnd-secBegin)+" nanosegundos");
            System.out.println("Tiempo de ejecucion paralelo: "+(parEnd-parBegin)+" nanosegundos");
        }
        
    }
}
