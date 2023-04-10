/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ed.veterinaria.model;

/**
 *
 * @author zarat
 */
public class Caninos extends Mascota {
    private int entrenamiento; 

    public Caninos() {
    }

    public Caninos(int entrenamiento, String nombre, String color, double edad, String raza) {
        super(nombre, color, edad, raza);
        this.entrenamiento = entrenamiento;
    }
    
    
}
