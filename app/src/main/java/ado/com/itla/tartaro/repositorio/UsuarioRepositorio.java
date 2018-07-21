package ado.com.itla.tartaro.repositorio;

import java.util.List;
import ado.com.itla.tartaro.entidad.Usuario;

public interface UsuarioRepositorio {
    boolean guardar(Usuario usuario);

    Usuario buscar(int id);

    List<Usuario> buscar(String buscar);
}
