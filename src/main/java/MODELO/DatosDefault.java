package MODELO;

public class DatosDefault {
    public static Mapa cargarMapaBase() {
        Mapa mapa = new Mapa();

        // Crear ciudades
        Ciudad guatemala = new Ciudad("Ciudad de Guatemala", 14.6349, -90.5069, 1500);
        Ciudad antigua = new Ciudad("Antigua Guatemala", 14.5596, -90.7343, 1530);
        Ciudad escuintla = new Ciudad("Escuintla", 14.3050, -90.7856, 400);
        Ciudad quetzaltenango = new Ciudad("Quetzaltenango", 14.8341, -91.5180, 2333);
        Ciudad puertoBarrios = new Ciudad("Puerto Barrios", 15.7167, -88.5833, 5);

        // Agregar ciudades al mapa
        mapa.agregarCiudad(guatemala);
        mapa.agregarCiudad(antigua);
        mapa.agregarCiudad(escuintla);
        mapa.agregarCiudad(quetzaltenango);
        mapa.agregarCiudad(puertoBarrios);

        // Conectar ciudades con distancias aproximadas en km (línea recta)
        mapa.agregarRuta(guatemala, antigua, 40);
        mapa.agregarRuta(antigua, escuintla, 35);
        mapa.agregarRuta(guatemala, escuintla, 60);
        mapa.agregarRuta(guatemala, quetzaltenango, 200);
        mapa.agregarRuta(guatemala, puertoBarrios, 295);
        mapa.agregarRuta(quetzaltenango, escuintla, 140);

        return mapa;
    }
}
