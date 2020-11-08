package com.example.controllibros_.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.controllibros_.Producto;
import com.example.controllibros_.ProductoADO;
import com.example.controllibros_.ProductoAdapter;
import com.example.controllibros_.R;
import com.example.controllibros_.ViewHolder;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private GridView gridView;
    private ArrayList<Producto> arrayProd;
    private ProductoAdapter adapter = null;
    private ProductoADO prodADO;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        gridView = (GridView) root.findViewById(R.id.gridVProductos);
        arrayProd = new ArrayList<>();
        try {
            prodADO = new ProductoADO(root.getContext());
            arrayProd = prodADO.llenaProd();
        } catch (NullPointerException e) {
            System.out.println("Error: " + e);
        }
        adapter = new ProductoAdapter(root.getContext(), R.layout.producto_items, arrayProd);
        gridView.setAdapter(adapter);

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick (AdapterView<?> adapterView, View view, int i, long l) {
                ViewHolder holder = new ViewHolder();
                holder = (ViewHolder) view.getTag();
                Toast.makeText(view.getContext(),"PRODUCTO SELECCIONADO: " + holder.getId(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return root;
    }
}