/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

public class TipoBarcoIterator implements BarcoIterator {

    private List<Barco> barcos;
    private String tipoFiltro;
    private int posicion = 0;

    public TipoBarcoIterator(List<Barco> barcos, String tipoFiltro) {
        this.barcos = barcos;
        this.tipoFiltro = tipoFiltro;
    }

    @Override
    public boolean tieneSiguiente() {
        while (posicion < barcos.size()) {
            if (barcos.get(posicion).getTipo().equalsIgnoreCase(tipoFiltro)) {
                return true;
            }
            posicion++;
        }
        return false;
    }

    @Override
    public Barco siguiente() {
        return barcos.get(posicion++);
    }
}
