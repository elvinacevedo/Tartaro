package ado.com.itla.tartaro.repositorio;

import java.util.List;
import ado.com.itla.tartaro.entidad.categoria;


public interface CategoriaRepositorio {
    boolean guardar(categoria categoria );

    categoria buscar(int id);

    List<categoria> buscar(String buscar);
}
