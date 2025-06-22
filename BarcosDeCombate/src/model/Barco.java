/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Barco implements Cloneable {
    private int id;
    private String nombre;
    private String tipo;       // Ej: Submarino, Destructor, Portaaviones
    private double tonelaje;   // Peso en toneladas
    private String estado;     // Ej: Activo, En reparación, Hundido

    public Barco(int id, String nombre, String tipo, double tonelaje, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tonelaje = tonelaje;
        this.estado = estado;
    }

    // Método Prototype
    @Override
    public Barco clone() {
        try {
            return (Barco) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Error al clonar el barco.");
            return null;
        }
    }

    // Getters y setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public double getTonelaje() { return tonelaje; }
    public String getEstado() { return estado; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setTonelaje(double tonelaje) { this.tonelaje = tonelaje; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "⚓ Barco ID: " + id +
               " | Nombre: " + nombre +
               " | Tipo: " + tipo +
               " | Tonelaje: " + tonelaje +
               " Tn | Estado: " + estado;
    }
}

