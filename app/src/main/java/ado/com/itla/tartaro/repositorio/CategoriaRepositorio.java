package ado.com.itla.tartaro.repositorio;

import ado.com.itla.tartaro.entidad.categoria;

public interface CategoriaRepositorio {
    boolean guardar(categoria categoria );

    categoria buscar(int id);

    List<Categoria> buscar(String buscar);
}
