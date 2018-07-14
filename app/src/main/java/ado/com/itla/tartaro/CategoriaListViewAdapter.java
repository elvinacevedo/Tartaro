package ado.com.itla.tartaro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ado.com.itla.tartaro.entidad.categoria;


public class CategoriaListViewAdapter extends BaseAdapter {

    private Context context;
    private List<categoria> categorias;

    public CategoriaListViewAdapter(Context context, List<categoria> categorias)
    {
        this.categorias = categorias;
        this.context = context;

    }

    @Override
    public int getCount() {
        return categorias.size();
    }

    @Override
    public Object getItem(int position) {
        return categorias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return categorias.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.categoriaitemrow,null);
        }

        categoria cat = categorias.get(position);

        TextView tid = convertView.findViewById(R.id.txtidcategoria);
        TextView tNombre = convertView.findViewById(R.id.txtNombreCategoria);

        tid.setText(cat.getId().toString());
        tNombre.setText(cat.getNombre());

        return convertView;
    }
}
