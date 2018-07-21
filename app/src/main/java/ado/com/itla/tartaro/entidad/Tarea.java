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
    private EstadoTarea estadoTarea;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public EstadoTarea getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(EstadoTarea estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    public ado.com.itla.tartaro.entidad.categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(ado.com.itla.tartaro.entidad.categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Usuario getUsuarioAsignado() {
        return usuarioAsignado;
    }

    public void setUsuarioAsignado(Usuario usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
    }

    public Date getFechaCompletado() {
        return fechaCompletado;
    }

    public void setFechaCompletado(Date fechaCompletado) {
        this.fechaCompletado = fechaCompletado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private categoria categoria;
    private Usuario usuarioCreador;
    private Usuario usuarioAsignado;
    private Date fechaCompletado;
    private String nombre;
    private String descripcion;

}
