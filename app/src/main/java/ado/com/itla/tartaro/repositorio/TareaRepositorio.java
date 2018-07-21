package ado.com.itla.tartaro.repositorio;

import java.util.List;

import ado.com.itla.tartaro.entidad.Tarea;
import ado.com.itla.tartaro.entidad.categoria;


public interface TareaRepositorio {
    boolean guardar(Tarea tarea);

    Tarea buscar(int id);

    List<Tarea> buscar(String buscar);
}


