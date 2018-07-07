package ado.com.itla.tartaro.repositorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
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
        List<categoria> categoria = new ArrayList<>();

        SQLiteDatabase db = conexionDB.getReadableDatabase();
        String columnas[] = {"id", CAMPO_NOMBRE};
        Cursor Cr = db.query(TABLA_NOMBRE,columnas,null,null,null,null,null,null);

        Cr.moveToFirst();

        while (!Cr.isAfterLast()){
            int id = Cr.getInt(Cr.getColumnIndex("id"));
            String nombre =  Cr.getString(Cr.getColumnIndex(CAMPO_NOMBRE));

            categoria cat = new categoria();
            cat.setId(id);
            cat.setNombre(nombre);

            categoria.add(cat);


            Cr.moveToNext();
        }
        Cr.close();
        db.close();

        return categoria;
    }
}
