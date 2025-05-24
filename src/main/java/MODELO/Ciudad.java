package MODELO;

import java.security.PublicKey;

public class Ciudad {
    private String nombre; //Sera el nombre de la ciudad
    private double latitud; //Posicion norte-sur en grados decimales, WGS84, World Geodetic System 1984
    private double longitud; //Longitud de la ciudad, este-oeste
    private double altura; //Altura sobre el nivel del mar de la ciudad

    public Ciudad(String nombre, double latitud, double longitud, double altura) { //Constructor para crear la ciudad, e inicializa ese objeto con cierto valores
        this.nombre = nombre;   //This.nombre; atribuyo de la clase llamado Nombre, y nombre es el parametro que recibe el constructor cuando creamos una ciudad
        this.latitud = latitud;
        this.longitud = longitud;
        this.altura = altura;
    }

    public String getNombre() {               //GETTERS & SETTERS, encapsulamiento
        return nombre;
    }

    public double getLatitud() {              //GETTERS & SETTERS, encapsulamiento
        return latitud;
    }

    public double getLongitud() {             //GETTERS & SETTERS, encapsulamiento
        return longitud;
    }

    public double getAltura() {                //GETTERS & SETTERS, encapsulamiento
        return altura;
    }

    public void setNombre(String nombre) {     //GETTERS & SETTERS, encapsulamiento
        this.nombre = nombre;
    }

    public void setLatitud(double latitud) {    //GETTERS & SETTERS, encapsulamiento
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {  //GETTERS & SETTERS, encapsulamiento
        this.longitud = longitud;
    }

    public void setAltura(double altura) {   //GETTERS & SETTERS, encapsulamiento
        this.altura = altura;
    }

    public String toString() {    //Imprime la ciudad en string, legible
        return nombre + " ( " + latitud + ", " + longitud + ", " + altura + "m)";
    }

    public boolean equals(Object obj) {   //Compara dos ciudades por nombre, sin importar mayusculas
        if (this == obj) return true;
        if (!(obj instanceof Ciudad)) return false;
        Ciudad otra = (Ciudad) obj;
        return this.nombre.equalsIgnoreCase(otra.nombre);
    }

    public int hashcode() {   //Asegura que las ciudades puedan usarse correctamente en estructuras como HashSet o HashMap
        return nombre.toLowerCase().hashCode();
    }
}
