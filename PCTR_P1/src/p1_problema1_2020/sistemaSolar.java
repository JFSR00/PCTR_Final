/*
1. La herencia en lenguaje Java es de tipo simple y proporciona, junto con
la implementacion de interfaces, el marco general que permite disponer de he-
bras concurrentes en este lenguaje. En este ejercicio, se pide que desarrolla un
esquema de clases que, utilizando herencia por especializacion, modele las rela-
ciones que a su juicio existen entre los siguientes elementos: cuerpo astrofisico,
estrella, cuerpo planetario, satelite, sol, tierra, luna. Cada uno de los elementos
citados estara en una clase diferente, almacenada en un fichero nombre.java,
que debera incluir metodos constructores, observadores y modificadores. Escri-
ba tambien un programa sistemaSolar.java que cree y utilice objetos de las
clases anteriores.
 */
package p1_problema1_2020;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class sistemaSolar {
    public static void main(String[] args){
        sol sol_ = new sol();
        tierra tierra_ = new tierra();
        luna luna_ =new luna();
        estrella ac_a = new estrella("Alfa Centauri A", 1.66922e6, 2.167e30, 1.94818e19, 3.50136e13, 5790, 5.81321e26);
        cuerpo_planetario saturno = new cuerpo_planetario("Saturno", 58232, 5.688e26, 8.27e13, 4.38e10, sol_);
        satelite titan = new satelite("Titán", 2574, 1.345e23, 7.16e9, 8.34e6, saturno);
        
        System.out.println(sol_.verDatos()+"\n\n");
        System.out.println(tierra_.verDatos()+"\n\n");
        System.out.println(luna_.verDatos()+"\n\n");
        System.out.println(ac_a.verDatos()+"\n\n");
        System.out.println(saturno.verDatos()+"\n\n");
        System.out.println(titan.verDatos()+"\n\n");
        
        saturno.setOrbit(ac_a);
        titan.setRad(luna_.getRad());
        System.out.println("Saturno orbita "+saturno.getOrbit().getName());
        System.out.println("El radio de la Luna es de "+luna_.getRad()+"Km y el de Titán es de "+titan.getRad());
    }
}
