package ed.veterinaria.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Felinos extends Mascota implements Listas<Felinos>{
    
    private boolean enfermedad;
    private boolean listaCreada = false;
    private final List<Felinos> felinos;

    public Felinos() {
        this.felinos = new ArrayList<>();
    }

    public Felinos(boolean enfermedad, String nombre, String color, double edad, String raza) {
        super(nombre, color, edad, raza);
        this.felinos = new ArrayList<>();
        this.enfermedad = enfermedad;
    }
    
    public boolean getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(boolean enfermedad) {
        this.enfermedad = enfermedad;
    }
    
    @Override
    public boolean equals(Object o) {
        Felinos felino = (Felinos) o;
        return enfermedad == felino.enfermedad
                && Double.compare(felino.getEdad(), getEdad()) == 0
                && Objects.equals(getNombre(), felino.getNombre())
                && Objects.equals(getColor(), felino.getColor())
                && Objects.equals(getRaza(), felino.getRaza());
    }
    
    @Override
    public List<Felinos> getLista(){
        return felinos;
    }
    
    @Override
    public void setLista(Felinos felino) {
        if (!this.felinos.contains(felino)) {
            this.felinos.add(felino);
        }
    }

    @Override
    public List<Felinos> delLista(int indice) {
        felinos.remove(indice);
        return felinos;
    }
    
    @Override
    public void inicializar(){
        if (felinos.isEmpty() && listaCreada==false){
            felinos.add(new Felinos(false, "Michi", "Blanco", 3, "Siamés"));
            felinos.add(new Felinos(true, "Tiara", "Gris", 3, "Ruso azul"));
            listaCreada=true;
        }
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