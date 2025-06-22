/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class BarcoService {

    private static BarcoService instancia;

    private List<Barco> barcos;

    private BarcoService() {
        barcos = new ArrayList<>();
    }

    public static BarcoService getInstancia() {
        if (instancia == null) {
            instancia = new BarcoService();
        }
        return instancia;
    }

    // CRUD básico

    public void agregarBarco(Barco barco) {
        barcos.add(barco);
        System.out.println("🚢 Barco agregado correctamente.");
    }

    public void eliminarBarcoPorId(int id) {
        barcos.removeIf(b -> b.getId() == id);
        System.out.println("❌ Barco eliminado (ID: " + id + ")");
    }

    public Barco buscarPorId(int id) {
        for (Barco b : barcos) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    public List<Barco> obtenerTodos() {
        return barcos;
    }
}
