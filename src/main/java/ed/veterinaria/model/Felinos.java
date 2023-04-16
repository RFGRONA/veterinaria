package ed.veterinaria.model;

import java.util.ArrayList;
import java.util.List;

public class Felinos extends Mascota implements Calculo{
    private boolean enfermedad;
    private boolean listaCreada = false;
    private List<Felinos> felinos = new ArrayList<>();

    public Felinos() {
    }

    public Felinos(boolean enfermedad, String nombre, String color, double edad, String raza) {
        super(nombre, color, edad, raza);
        this.enfermedad = enfermedad;
    }
    
    public List<Felinos> getFelinos(){
        return felinos;
    }
    public void setFelinos(Felinos felino){
        this.felinos.add(felino);
    }
    
    public List<Felinos> delFelinos(int i){
        felinos.remove(i);
        return felinos;
    }
    
    public void inicializar(){
        if (felinos.isEmpty() && listaCreada==false){
            felinos.add(new Felinos(false, "Michi", "Blanco", 3, "Siamés"));
            felinos.add(new Felinos(true, "Tiara", "Gris", 3, "Ruso azul"));
            listaCreada=true;
        }
    }

    public boolean getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(boolean enfermedad) {
        this.enfermedad = enfermedad;
    }
    
    @Override
    public double calculo(){
        double promedio = felinos.size();
        double edad = 0;
        double total;
        for (Felinos felino : felinos) {
            edad += felino.getEdad();
        }
        total = Math.round( edad/promedio * 100d) / 100d;
        return total;
    }
}
