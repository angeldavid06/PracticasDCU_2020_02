package com.example.controllibros_;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class ProductoAdapter extends BaseAdapter {
    private Context context;
    private  int layout;
    private ArrayList<Producto> arrayProducto;
    public ProductoAdapter(Context context, int layout, ArrayList<Producto> productos) {
        this.context= context;
        this.layout = layout;
        this.arrayProducto = productos;
    }
    @Override
    public int getCount() {
        return arrayProducto.size();
    }
    @Override
    public Object getItem(int i) {
        return arrayProducto.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = new ViewHolder();
        String archivo;
        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.loc_textVProd = (TextView) row.findViewById(R.id.textVProd);
            holder.loc_textVPrecio = (TextView) row.findViewById(R.id.textVPrecio);
            holder.loc_imgViewProd = (ImageView) row.findViewById(R.id.imgViewProd);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }
        Producto prod = arrayProducto.get(i);
        holder.loc_textVProd.setText(prod.getNombreprod());
        holder.loc_textVPrecio.setText(String.valueOf(prod.getPrecioprod()));
        archivo = prod.getFotoprod();

        if (archivo==null){archivo="no";}else{
            String[] palabra = archivo.split("\\.");
            archivo = palabra[0];
        }

        String getPkg=context.getPackageName();
        int aux=context.getResources().getIdentifier(archivo, "drawable",getPkg);
        holder.loc_imgViewProd.setImageResource(aux);
        return row;
    }
    private class ViewHolder{
        ImageView loc_imgViewProd;
        TextView loc_textVProd, loc_textVPrecio;
    }
}
