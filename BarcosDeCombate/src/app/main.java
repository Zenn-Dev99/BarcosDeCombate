/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import model.*;
import java.util.List;
import java.util.Scanner;

public class main {
    private static final Scanner sc = new Scanner(System.in);
    private static final BarcoService sistema = BarcoService.getInstancia();
    private static int idCounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n⚓ Menú CRUD de Barcos ⚓");
            System.out.println("1. Agregar barco");
            System.out.println("2. Ver todos");
            System.out.println("3. Eliminar por ID");
            System.out.println("4. Clonar barco");
            System.out.println("5. Ver barcos por tipo (Iterator)");
            System.out.println("6. Importar barco externo (Adapter)");
            System.out.println("7. Salir");
            System.out.print("Opción: ");
            int opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1 -> agregarBarco();
                case 2 -> listarBarcos();
                case 3 -> eliminarBarco();
                case 4 -> clonarBarco();
                case 5 -> verPorTipo();
                case 6 -> importarBarco();
                case 7 -> {
                    System.out.println("Cerrando sistema...");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void agregarBarco() {
        System.out.print("Nombre: "); String nombre = sc.nextLine();
        System.out.print("Tipo: "); String tipo = sc.nextLine();
        System.out.print("Tonelaje: "); double peso = sc.nextDouble(); sc.nextLine();
        System.out.print("Estado: "); String estado = sc.nextLine();

        Barco b = new Barco(idCounter++, nombre, tipo, peso, estado);
        sistema.agregarBarco(b);
    }

    private static void listarBarcos() {
        List<Barco> lista = sistema.obtenerTodos();
        if (lista.isEmpty()) System.out.println("No hay barcos.");
        else lista.forEach(System.out::println);
    }

    private static void eliminarBarco() {
        System.out.print("ID a eliminar: ");
        int id = sc.nextInt(); sc.nextLine();
        sistema.eliminarBarcoPorId(id);
    }

    private static void clonarBarco() {
        System.out.print("ID del barco a clonar: ");
        int id = sc.nextInt(); sc.nextLine();
        Barco original = sistema.buscarPorId(id);
        if (original != null) {
            Barco copia = original.clone();
            copia.setId(idCounter++);
            copia.setNombre(original.getNombre() + " (Copia)");
            sistema.agregarBarco(copia);
        } else System.out.println("Barco no encontrado.");
    }

    private static void verPorTipo() {
        System.out.print("Tipo a filtrar (ej: Submarino): ");
        String tipo = sc.nextLine();
        BarcoIterator iterador = new TipoBarcoIterator(sistema.obtenerTodos(), tipo);
        boolean encontrado = false;
        while (iterador.tieneSiguiente()) {
            System.out.println(iterador.siguiente());
            encontrado = true;
        }
        if (!encontrado) System.out.println("No se encontraron barcos de ese tipo.");
    }

    private static void importarBarco() {
        BarcoExterno externo = new BarcoImportado(); // fuente externa simulada
        Barco adaptado = new BarcoAdapter(idCounter++, externo);
        sistema.agregarBarco(adaptado);
        System.out.println("Barco importado vía adapter.");
    }
}
