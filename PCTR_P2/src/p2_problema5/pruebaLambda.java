/*
5. Escriba ahora una condici ́on de concurso de dos tareas sobre una variable
compartida, utilizando para modelar a la tareas expresiones lambda.
 */
package p2_problema5;

/**
 *
 * @author Juan Francisco Santos Relinque
 */
public class pruebaLambda {
    private static int dato;
    
    public static void main(String[] args) throws InterruptedException {
        dato = 0;
        
        Thread h1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100000; i++)
                    dato++;
            }
        });
        
        Thread h2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100000; i++)
                    dato--;
            }
        });
        
        h1.start();
        h2.start();
        
        h1.join();
        h2.join();
        
        System.out.println("Dato: " + dato);
        
    }
}
