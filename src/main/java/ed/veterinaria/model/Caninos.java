package ed.veterinaria.model;

import java.util.ArrayList;
import java.util.List;

public class Caninos extends Mascota implements Calculo{
    
    private int entrenamiento; 
    private boolean listaCreada = false;
    private List<Caninos> caninos = new ArrayList<>();

    public Caninos() {
    }

    public Caninos(int entrenamiento, String nombre, String color, double edad, String raza) {
        super(nombre, color, edad, raza);
        this.entrenamiento = entrenamiento;
    }

    public List<Caninos> getCaninos(){
        return caninos;
    }
    
    public List<Caninos> delCaninos(int i){
        caninos.remove(i);
        return caninos;
    }
    
    public void setCaninos(Caninos canino){
           this.caninos.add(canino);
    }
    
    public void inicializar(){
        if (caninos.isEmpty() && listaCreada==false){
            caninos.add(new Caninos(5, "Mateo", "Café", 4, "Criollo"));
            caninos.add(new Caninos(5, "Firualis", "Blanco", 7, "Criollo"));
            listaCreada=true;
        }
    }

    public int getEntrenamiento() {
        return entrenamiento;
    }

    public void setEntrenamiento(int entrenamiento) {
        this.entrenamiento = entrenamiento;
    }
    
    @Override
    public double calculo(){
        double promedio = caninos.size();
        double edad = 0;
        double total;
        for (Caninos canino : caninos) {
            edad += canino.getEdad();
        }
        total = Math.round( edad/promedio * 100d) / 100d;
        return total;
    }
    
}
