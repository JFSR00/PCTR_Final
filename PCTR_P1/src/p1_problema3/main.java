/*
3. La integral denida en [0-1] de una funcion real de variable real f(x) pue-
de calcularse mediante un metodo de Monte-Carlo (probabilstico) inscribiendo
la curva de la funcion en un cuadrado de lado igual a la unidad. Para aproximar
el valor de la integral, se generan puntos aleatorios en el marco determinado por
el cuadrado, y se cuentan unicamente aquellos puntos que estan situados bajo
la curva. La razon entre el numero de puntos bajo la curva y el numero total
de puntos es una aproximacion al valor buscado que naturalmente, conforme
mayor es el numero de puntos, mejora la aproximacion. Escriba un programa
en Java que permita realizar tal calculo, leyendo desde teclado el numero de
puntos con el cual generar la aproximacion para las funciones siguientes:
f(x) = sin
f(x) = x
 */
package p1_problema3;

import java.util.Scanner;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        funcion1 f1 = new funcion1();
        funcion2 f2 = new funcion2();
        
        System.out.print("Introduzca número de puntos para la función 1: ");
        intDefinidaMonteCarlo.MonteCarlo(in.nextInt(), f1);
        System.out.print("Introduzca número de puntos para la función 2: ");
        intDefinidaMonteCarlo.MonteCarlo(in.nextInt(), f2);
    }
}
