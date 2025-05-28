package GUI;

import MODELO.*;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import MODELO.DatosDefault;


import java.util.List;

public class VentanaPrincipal {
    private Mapa mapa;
    private TextArea areaSalida;
    private ComboBox<String> comboOrigen;
    private ComboBox<String> comboDestino;

    public void mostrar(Stage stage) {
        mapa = DatosDefault.cargarMapaBase();

        Label labelTitulo = new Label("Sistema de Rutas entre Ciudades");
        labelTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        comboOrigen = new ComboBox<>();
        comboDestino = new ComboBox<>();

        for (Ciudad ciudad : mapa.getCiudades()) {
            comboOrigen.getItems().add(ciudad.getNombre());
            comboDestino.getItems().add(ciudad.getNombre());
        }

        Button btnCalcularRuta = new Button("Calcular Ruta Más Corta");
        Button btnSimularViaje = new Button("Simular Viaje");

        areaSalida = new TextArea();
        areaSalida.setEditable(false);
        areaSalida.setPrefHeight(300);

        btnCalcularRuta.setOnAction(e -> calcularRuta());
        btnSimularViaje.setOnAction(e -> simularViaje());

        VBox layout = new VBox(10,
                labelTitulo,
                new HBox(10, new Label("Origen:"), comboOrigen, new Label("Destino:"), comboDestino),
                new HBox(10, btnCalcularRuta, btnSimularViaje),
                areaSalida
        );
        layout.setPadding(new Insets(15));

        Scene scene = new Scene(layout, 600, 450);
        stage.setTitle("Sistema de Rutas GPS");
        stage.setScene(scene);
        stage.show();
    }

    private void calcularRuta() {
        String nombreOrigen = comboOrigen.getValue();
        String nombreDestino = comboDestino.getValue();

        if (nombreOrigen == null || nombreDestino == null) {
            areaSalida.setText("Selecciona una ciudad de origen y una de destino.");
            return;
        }

        Ciudad origen = mapa.buscarCiudadPorNombre(nombreOrigen);
        Ciudad destino = mapa.buscarCiudadPorNombre(nombreDestino);

        List<Ciudad> ruta = mapa.dijkstra(origen, destino);

        if (ruta.isEmpty()) {
            areaSalida.setText("No existe ruta entre las ciudades seleccionadas.");
        } else {
            StringBuilder sb = new StringBuilder("Ruta más corta:\n");
            for (Ciudad ciudad : ruta) {
                sb.append(" - ").append(ciudad.getNombre()).append("\n");
            }
            areaSalida.setText(sb.toString());
        }
    }

    private void simularViaje() {
        String textoActual = areaSalida.getText();
        if (textoActual == null || !textoActual.contains("Ruta más corta:")) {
            areaSalida.setText("Primero debes calcular una ruta.");
            return;
        }

        String[] lineas = textoActual.split("\n");
        StringBuilder sb = new StringBuilder("Simulación paso a paso:\n");
        for (int i = 1; i < lineas.length; i++) {
            sb.append("Conduciendo hacia ").append(lineas[i].trim()).append("\n");
        }
        areaSalida.setText(sb.toString());
    }
}

