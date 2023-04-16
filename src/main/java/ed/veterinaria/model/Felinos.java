/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ed.veterinaria.model;

/**
 *
 * @author zarat
 */
public class Felinos extends Mascota {
    private boolean enfermedad; 

    public Felinos() {
    }

    public Felinos(boolean enfermedad, String nombre, String color, double edad, String raza) {
        super(nombre, color, edad, raza);
        this.enfermedad = enfermedad;
    }
    
    
    public boolean isEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(boolean enfermedad) {
        this.enfermedad = enfermedad;
    }
    
    
}
