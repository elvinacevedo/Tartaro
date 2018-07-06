package ado.com.itla.tartaro.repositorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import ado.com.itla.tartaro.entidad.categoria;

import ado.com.itla.tartaro.entidad.categoria;
import ado.com.itla.tartaro.repositorio.CategoriaRepositorio;

public class CategoriaRepositorioDBImp implements CategoriaRepositorio {

    private  ConexionDB conexionDB;
    private static final String CAMPO_NOMBRE = "nombre";
    private static final String TABLA_NOMBRE = "categoria";

    public CategoriaRepositorioDBImp(Context Context) {
        this.conexionDB = new ConexionDB(Context);
    }

    @Override
    public boolean guardar(categoria categoria) {

        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NOMBRE,categoria.getNombre());

        SQLiteDatabase db =  conexionDB.getWritableDatabase();

        Long id = db.insert(TABLA_NOMBRE,null, cv);
        db.close();

        if (id.intValue() > 0){
            categoria.setId(id.intValue());
            return true;

        }

        return false;
    }

    @Override
    public categoria buscar(int id) {
        return null;
    }

    @Override
    public List<categoria> buscar(String buscar) {
        return null;
    }
}
