package MODELO;

import java.util.*;

public class Mapa {
    private Map<Ciudad, List<Conexion>> grafo;

    public Mapa() {
        grafo = new HashMap<>();
    }

    public void agregarCiudad(Ciudad ciudad) {
        grafo.putIfAbsent(ciudad, new ArrayList<>());
    }

    public void eliminarCiudad(Ciudad ciudad) {
        grafo.remove(ciudad);
        for (List<Conexion> conexiones : grafo.values()) {
            conexiones.removeIf(c -> c.getDestino().equals(ciudad));
        }
    }

    public void agregarRuta(Ciudad origen, Ciudad destino, double distancia) {
        agregarCiudad(origen);
        agregarCiudad(destino);
        grafo.get(origen).add(new Conexion(destino, distancia));
    }

    public void eliminarRuta(Ciudad origen, Ciudad destino) {
        List<Conexion> conexiones = grafo.get(origen);
        if (conexiones != null) {
            conexiones.removeIf(c -> c.getDestino().equals(destino));
        }
    }

    public boolean hayCamino(Ciudad origen, Ciudad destino) {
        Set<Ciudad> visitadas = new HashSet<>();
        return dfs(origen, destino, visitadas);
    }

    private boolean dfs(Ciudad actual, Ciudad destino, Set<Ciudad> visitadas) {
        if (actual.equals(destino)) return true;
        visitadas.add(actual);
        for (Conexion conexion : grafo.getOrDefault(actual, Collections.emptyList())) {
            if (!visitadas.contains(conexion.getDestino())) {
                if (dfs(conexion.getDestino(), destino, visitadas)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Ciudad> dijkstra(Ciudad origen, Ciudad destino) {
        Map<Ciudad, Double> distancias = new HashMap<>();
        Map<Ciudad, Ciudad> anteriores = new HashMap<>();
        PriorityQueue<Conexion> cola = new PriorityQueue<>(Comparator.comparingDouble(Conexion::getDistancia));

        for (Ciudad ciudad : grafo.keySet()) {
            distancias.put(ciudad, Double.POSITIVE_INFINITY);
        }
        distancias.put(origen, 0.0);
        cola.add(new Conexion(origen, 0));

        while (!cola.isEmpty()) {
            Ciudad actual = cola.poll().getDestino();

            for (Conexion conexion : grafo.getOrDefault(actual, Collections.emptyList())) {
                Ciudad vecino = conexion.getDestino();
                double nuevaDist = distancias.get(actual) + conexion.getDistancia();
                if (nuevaDist < distancias.get(vecino)) {
                    distancias.put(vecino, nuevaDist);
                    anteriores.put(vecino, actual);
                    cola.add(new Conexion(vecino, nuevaDist));
                }
            }
        }

        List<Ciudad> camino = new ArrayList<>();
        Ciudad actual = destino;
        while (actual != null && anteriores.containsKey(actual)) {
            camino.add(0, actual);
            actual = anteriores.get(actual);
        }
        if (actual == origen) {
            camino.add(0, origen);
        }
        return camino;
    }

    public void mostrarGrafo() {
        for (Ciudad ciudad : grafo.keySet()) {
            System.out.print(ciudad.getNombre() + " -> ");
            for (Conexion conexion : grafo.get(ciudad)) {
                System.out.print(conexion.getDestino().getNombre() + " (" + conexion.getDistancia() + " km), ");
            }
            System.out.println();
        }
    }
    public Set<Ciudad> getCiudades() {
        return grafo.keySet();
    }

    public Ciudad buscarCiudadPorNombre(String nombre) {
        for (Ciudad ciudad : grafo.keySet()) {
            if (ciudad.getNombre().equalsIgnoreCase(nombre)) {
                return ciudad;
            }
        }
        return null;
    }

}
