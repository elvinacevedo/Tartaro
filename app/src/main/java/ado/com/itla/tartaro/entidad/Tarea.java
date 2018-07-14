package ado.com.itla.tartaro.entidad;

import android.content.Intent;
import ado.com.itla.tartaro.entidad.categoria;
import ado.com.itla.tartaro.entidad.Usuario;
import java.util.Date;

public class Tarea {
    public  enum EstadoTarea{
        PENDIENTE,
        EN_PROCESO,
        LISTA
    }

    private Integer id;
    private Date fecha;
    private EstadoTarea stadoTarea;
    private categoria categoria;
    private Usuario usuario;
}
