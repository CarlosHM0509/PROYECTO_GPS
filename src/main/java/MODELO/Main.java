package MODELO;

public class Main {
    public static void main(String[] args) {
        // Crear ciudades
        Ciudad guatemala = new Ciudad("Ciudad de Guatemala", 14.6349, -90.5069, 1500);
        Ciudad antigua = new Ciudad("Antigua Guatemala", 14.5596, -90.7343, 1530);

        // Imprimir ciudades
        System.out.println("Probando clase Ciudad:");
        System.out.println(guatemala);
        System.out.println(antigua);

        // Probar método equals
        Ciudad copiaGuatemala = new Ciudad("Ciudad de Guatemala", 0, 0, 0);
        System.out.println("¿Guatemala es igual a su copia? " + guatemala.equals(copiaGuatemala));
    }
}

