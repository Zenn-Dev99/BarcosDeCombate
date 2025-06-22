/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class BarcoImportado implements BarcoExterno {
    @Override public String getNombreCodigo() { return "XK-99 Phantom"; }
    @Override public String getClasificacion() { return "Submarino"; }
    @Override public String getPesoTon() { return "3500.5"; }
    @Override public String getEstado() { return "Activo"; }
}

