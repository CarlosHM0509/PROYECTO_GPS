package MODELO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Mapa mapa = DatosDefault.cargarMapaBase();

        System.out.println("Grafo de ciudades:");
        mapa.mostrarGrafo();

        Ciudad origen = new Ciudad("Ciudad de Guatemala", 0, 0, 0);
        Ciudad destino = new Ciudad("Puerto Barrios", 0, 0, 0);

        System.out.println("\n¿Hay camino entre Guatemala y Puerto Barrios?: " + mapa.hayCamino(origen, destino));

        System.out.println("\nRuta más corta de Guatemala a Puerto Barrios:");
        List<Ciudad> ruta = mapa.dijkstra(origen, destino);
        for (Ciudad ciudad : ruta) {
            System.out.println(" - " + ciudad);
        }
    }
}

