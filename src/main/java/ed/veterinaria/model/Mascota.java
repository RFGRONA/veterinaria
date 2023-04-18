package ed.veterinaria.model;

public abstract class Mascota{
    private String nombre;
    private String color;
    private double edad;
    private String raza;
    
    public abstract void inicializar();
    public abstract double calculo();
    
    public Mascota(){
    }

    public Mascota(String nombre, String color, double edad, String raza) {
        this.nombre = nombre;
        this.color = color;
        this.edad = edad;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEdad() {
        return edad;
    }

    public void setEdad(double edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}