/*
4. Escriba un programa en Java que lea una secuencia de valores numericos
cuya longitud sera determinada por el usuario mediante un parametro transfe-
rido desde la linea de comandos del sistema. El programa leera la secuencia, y
debera calcular e imprimir parametros estadisticos estandar como media, mo-
da, varianza y desviacion tipica, ofreciendo al usuario un menu (estructurado
mediante switch) donde elegira el estadistico que desea calcular. Guarde su
trabajo en un fichero llamado Estadistica.java.
 */
package p1_problema4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class Estadistica {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        double[] elem = new double[args.length];
	int opt = 5;
        
        for(int i=0; i<args.length; i++){
            elem[i]= Double.parseDouble(args[i]);
        }
	
	while(opt != 0){
	    System.out.print("Elementos: ");
            for(int i=0; i<args.length; i++){
                System.out.print(elem[i]+" ");
            }
	    
            System.out.print(""
                    + "ESTADISTICA\n"
                    + "-----------\n"
                    + "\n"
                    + "1. Media\n"
                    + "2. Moda\n"
                    + "3. Varianza\n"
                    + "4. Desviacion tipica\n"
                    + "\n"
                    + "0. Salir\n"
                    + "\n"
                    + "Operacion: "
            );
            
            opt = s.nextInt();
            
            switch(opt){
                case 1:
                    System.out.println(""
                            + "\n"
                            + "Media: " + media(elem)
                            + "\n"
                    );
                    break;
                case 2:
                    System.out.println(""
                            + "\n"
                            + "Moda: " + moda(elem)
                            + "\n"
                    );
                    break;
                case 3:
                    System.out.println(""
                            + "\n"
                            + "Varianza: " + varianza(elem)
                            + "\n"
                    );
                    break;
                case 4:
                    System.out.println(""
                            + "\n"
                            + "Desviacion tipica: " + desvTipica(elem)
                            + "\n"
                    );
                    break;
                default:
                    break;
            }
        }
    }
    
    public static double media(double[] v){
        double res=0;
        for(int i=0; i<v.length; i++){
            res+=v[i];
        }
        return res/(double)v.length;
    }
    
    public static double moda(double[] v){
        Arrays.sort(v);
        double m1=0, m2=0;
        int cont1=0, cont2=0;
        
        for(int i=0; i<v.length; i++){
            if(v[i] == m2){
                cont2++;
            }else{
                m2 = v[i];
                cont2 = 1;
            }
            if(cont1 < cont2){
                m1 = m2;
                cont1 = cont2;
            }
        }
        
        return m1;
    }
    
    public static double varianza(double[] v){
        double med = media(v), var = 0;
        
        for(int i=0; i<v.length; i++){
            var += Math.pow((v[i] - med), 2);
        }
        
        return var/(double)v.length;
    }
    
    public static double desvTipica(double[] v){
        return Math.sqrt(varianza(v));
    }
}
