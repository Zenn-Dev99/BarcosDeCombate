/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class BarcoAdapter extends Barco {
    public BarcoAdapter(int id, BarcoExterno externo) {
        super(id,
              externo.getNombreCodigo(),
              externo.getClasificacion(),
              Double.parseDouble(externo.getPesoTon()),
              externo.getEstado());
    }
}

