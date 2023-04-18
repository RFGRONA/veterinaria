package ed.veterinaria.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Caninos extends Mascota implements Calculo {

    private int entrenamiento;
    private boolean listaCreada = false;
    private List<Caninos> caninos = new ArrayList<>();

    public Caninos() {
    }

    public Caninos(int entrenamiento, String nombre, String color, double edad, String raza) {
        super(nombre, color, edad, raza);
        this.entrenamiento = entrenamiento;
    }

    public List<Caninos> getCaninos() {
        return caninos;
    }

    public List<Caninos> delCaninos(int i) {
        caninos.remove(i);
        return caninos;
    }

    @Override
    public boolean equals(Object o) {
        Caninos canino = (Caninos) o;
        return entrenamiento == canino.entrenamiento
                && Double.compare(canino.getEdad(), getEdad()) == 0
                && Objects.equals(getNombre(), canino.getNombre())
                && Objects.equals(getColor(), canino.getColor())
                && Objects.equals(getRaza(), canino.getRaza());
    }

    public void setCaninos(Caninos canino) {
        if (!this.caninos.contains(canino)) {
            this.caninos.add(canino);
        }
    }

    public int getEntrenamiento() {
        return entrenamiento;
    }

    public void setEntrenamiento(int entrenamiento) {
        this.entrenamiento = entrenamiento;
    }
    
    @Override
    public void inicializar() {
        if (caninos.isEmpty() && listaCreada == false) {
            caninos.add(new Caninos(5, "Mateo", "Café", 4, "Criollo"));
            caninos.add(new Caninos(5, "Firualis", "Blanco", 7, "Criollo"));
            listaCreada = true;
        }
    }

    @Override
    public double calculo() {
        double promedio = caninos.size();
        double edad = 0;
        double total;
        for (Caninos canino : caninos) {
            edad += canino.getEdad();
        }
        total = Math.round(edad / promedio * 100d) / 100d;
        return total;
    }

}
