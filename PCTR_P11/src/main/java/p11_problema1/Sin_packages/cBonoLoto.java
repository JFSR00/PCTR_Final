/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class cBonoLoto {
    public static void main(String[] args) throws Exception {
        
        iBonoLoto servidor = (iBonoLoto)Naming.lookup("//localhost/bonoloto");
        int combinacion[] = new int[6];
        Scanner sc = new Scanner(System.in);
        
        do{
            for(int i=0; i<combinacion.length; i++){
                combinacion[i] = sc.nextInt();
            }
        }while(!servidor.compApuesta(combinacion));
    }
}
