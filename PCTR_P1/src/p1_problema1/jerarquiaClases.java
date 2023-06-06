/*
1. La herencia en lenguaje Java es de tipo simple y proporciona, junto con la
implementación de interfaces, el marco general que permite disponer de hebras
concurrentes en este lenguaje. En este ejercicio, se pide que desarrolla un esquema
de clases que, utilizando herencia por especialización, modele las relaciones
que a su juicio existen entre los siguientes elementos: animal, hervíboros, carnívoros,
omnívoros, conejo, león hiena, hombre. Escriba clases para modelar aquellas
entidades que considere que pueden serlo, e instancia objetos en los casos
restatnes.Para cada clase que considere, descríbala en un fichero nombre.java,
que deberá incluir métodos constructores, observadores y modificadores. Escriba
también un programa jerarquiaClases.java que cree y utilice objetos de
las clases anteriores.
 */
package p1_problema1;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class jerarquiaClases {
    public static void main(String[] args) {
	hombre adan = new hombre("Adan", "masculino");
	hombre eva = new hombre("Eva", "femenino");
	
	hiena hiena1 = new hiena(3);
	leon leon1 = new leon(5);
	conejo conejo1 = new conejo("mixomatosis");
	
	System.out.println("\n"
		+ "\nEspecie: " + adan.getEspecie()
		+ "\nNombre: " + adan.getNombre()
		+ "\nSexo: " + adan.getSexo()
		+ "\nAlimentacion: " + adan.getAlimentacion()
		+ "\nNumero de piernas: " + adan.getNumPatas()
	);
	
	System.out.println("\n"
		+ "\nEspecie: " + eva.getEspecie()
		+ "\nNombre: " + eva.getNombre()
		+ "\nSexo: " + eva.getSexo()
		+ "\nAlimentacion: " + eva.getAlimentacion()
		+ "\nNumero de piernas: " + eva.getNumPatas()
	);
	
	System.out.println("\n"
		+ "\nEspecie: " + hiena1.getEspecie()
		+ "\nAlimentacion: " + hiena1.getAlimentacion()
		+ "\nNumero de patas: " + hiena1.getNumPatas()
		+ "\nAnimales cazados: " + hiena1.getAnimalesCazados()
	);
	
	System.out.println("\n"
		+ "\nEspecie: " + leon1.getEspecie()
		+ "\nAlimentacion: " + leon1.getAlimentacion()
		+ "\nNumero de patas: " + leon1.getNumPatas()
		+ "\nAnimales cazados: " + leon1.getAnimalesCazados()
	);
	
	System.out.println("\n"
		+ "\nEspecie: " + conejo1.getEspecie()
		+ "\nAlimentacion: " + conejo1.getAlimentacion()
		+ "\nNumero de patas: " + conejo1.getNumPatas()
		+ "\nEnfermedades: " + conejo1.getEnfermedades()
	);
	
	System.out.println("########################################");
	conejo1.setEnfermedades("ninguna");
	
	System.out.println("\n"
		+ "\nEspecie: " + conejo1.getEspecie()
		+ "\nAlimentacion: " + conejo1.getAlimentacion()
		+ "\nNumero de patas: " + conejo1.getNumPatas()
		+ "\nEnfermedades: " + conejo1.getEnfermedades()
	);
	
	System.out.println("########################################");
	conejo1.setEnfermedades("muerto");
	leon1.setAnimalesCazados(leon1.getAnimalesCazados() + 1);
	
	System.out.println("\n"
		+ "\nEspecie: " + conejo1.getEspecie()
		+ "\nAlimentacion: " + conejo1.getAlimentacion()
		+ "\nNumero de patas: " + conejo1.getNumPatas()
		+ "\nEnfermedades: " + conejo1.getEnfermedades()
	);
	
	System.out.println("\n"
		+ "\nEspecie: " + leon1.getEspecie()
		+ "\nAlimentacion: " + leon1.getAlimentacion()
		+ "\nNumero de patas: " + leon1.getNumPatas()
		+ "\nAnimales cazados: " + leon1.getAnimalesCazados()
	);
    }
}
