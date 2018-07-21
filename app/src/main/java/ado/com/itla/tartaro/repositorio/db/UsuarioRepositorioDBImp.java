package ado.com.itla.tartaro.repositorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ado.com.itla.tartaro.entidad.Tarea;
import ado.com.itla.tartaro.entidad.Usuario;
import ado.com.itla.tartaro.entidad.categoria;

public class UsuarioRepositorioDBImp {

    private  ConexionDB conexionDB;
    private static final String CAMPO_NOMBRE = "nombre";
    private static final String CAMPO_EMAIL = "email";
    private static final String CAMPO_PASSWORD = "password";
    private static final String CAMPO_TIPO_USUARIO = "TipoUsuario";
    private static final String TABLA_NOMBRE = "usuario";

    public UsuarioRepositorioDBImp (Context Context) {
        this.conexionDB = new ConexionDB(Context);
    }


    public boolean guardar(Usuario usuario)
    {
        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NOMBRE,usuario.getNombre());
        cv.put(CAMPO_EMAIL, usuario.getEmail());
        cv.put(CAMPO_PASSWORD, usuario.getPassword());
        cv.put(CAMPO_TIPO_USUARIO,usuario.getTipoUsuario().name());

        //Usuario.TipoUsuario tipoUsuario = Usuario.TipoUsuario.valueOf("NORMAL");
        SQLiteDatabase db =  conexionDB.getWritableDatabase();

        Long id = db.insert(TABLA_NOMBRE,null, cv);
        db.close();

        if (id.intValue() > 0){
            usuario.setId(id.intValue());
            return true;

        }

        return false;
    }

    public Usuario buscar(int id) {
        return null;
    }

    public List<Usuario> buscar(String buscar) {
        List<Usuario> usuarios = new ArrayList<>();

        SQLiteDatabase db = conexionDB.getReadableDatabase();
        String columnas[] = {"id", CAMPO_NOMBRE, CAMPO_EMAIL,CAMPO_PASSWORD,CAMPO_TIPO_USUARIO};
        Cursor Cr = db.query(TABLA_NOMBRE,columnas,null,null,null,null,null,null);

        Cr.moveToFirst();

        while (!Cr.isAfterLast()){
            int id = Cr.getInt(Cr.getColumnIndex("id"));
            String nombre =  Cr.getString(Cr.getColumnIndex(CAMPO_NOMBRE));
            String email = Cr.getString(Cr.getColumnIndex(CAMPO_EMAIL));
            String password = Cr.getString(Cr.getColumnIndex(CAMPO_PASSWORD));
            String tipo_usuario = Cr.getString(Cr.getColumnIndex(CAMPO_TIPO_USUARIO));

            Usuario usu = new Usuario();
            usu.setId(id);
            usu.setNombre(nombre);
            usu.setEmail(email);
            usu.setPassword(password);
            usu.setTipoUsuario(Usuario.TipoUsuario.valueOf(tipo_usuario));

            usuarios.add(usu);
            Cr.moveToNext();
        }
        Cr.close();
        db.close();

        return usuarios;
    }
}
