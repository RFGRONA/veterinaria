package ed.veterinaria.model;

import java.util.List;

public interface Listas<T extends Mascota> {
    List<T> getLista();
    void setLista(T objeto);
    List<T> delLista(int indice);
}
