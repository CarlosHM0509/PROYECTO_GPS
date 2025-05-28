package MODELO;

public class Conexion {
    private Ciudad destino;
    private double distancia;

    public Conexion(Ciudad destino, double distancia) {
        this.destino = destino;
        this.distancia = distancia;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public double getDistancia() {
        return distancia;
    }
}

