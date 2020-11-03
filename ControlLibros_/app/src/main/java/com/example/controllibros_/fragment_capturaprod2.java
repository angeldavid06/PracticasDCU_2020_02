package com.example.controllibros_;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_capturaprod2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_capturaprod2 extends Fragment {
    Producto prod_datos;
    ProductoADO datosBD;
    private EditText loc_editCveprod, loc_editNombreprod, loc_editAutorprod,loc_editPrecioprod;
    private CheckBox loc_chkActivo;
    private Button loc_btnGuardar;
    private Spinner loc_spnFotoprod;
    private String varfoto;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_capturaprod2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_capturaprod2.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_capturaprod2 newInstance(String param1, String param2) {
        fragment_capturaprod2 fragment = new fragment_capturaprod2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_capturaprod, container, false);
        prod_datos = new Producto();
        datosBD = new ProductoADO(view.getContext());
        loc_editCveprod = (EditText) view.findViewById(R.id.editCveprod);
        loc_editNombreprod = (EditText) view.findViewById(R.id.editNombreprod);
        loc_editAutorprod = (EditText) view.findViewById(R.id.editAutorprod);
        loc_editPrecioprod = (EditText) view.findViewById(R.id.editPrecioprod);
        loc_chkActivo = (CheckBox) view.findViewById(R.id.chkActivo);
        loc_btnGuardar = (Button) view.findViewById(R.id.btnGuardar);
        loc_spnFotoprod=(Spinner)
                view.findViewById(R.id.spnFotoprod);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(view.getContext(),
                R.array.cbo_fotoprod,R.layout.support_simple_spinner_dropdown_item);
        loc_spnFotoprod.setAdapter(adapter);
        loc_spnFotoprod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                varfoto=adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public
            void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        loc_btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    preparaDatos();
                    datosBD.abrirBD();
                    Log.d("MyApp", "Abrio la base......................... ");
                    datosBD.insertarProducto(prod_datos);
                    Log.d("MyApp", "Inserto en la base......................... ");
                    Toast.makeText(view.getContext(),"Se guardo con exito",Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Log.d("MyApp", "Error:......................... " + e.getMessage());
                }
            }
        });
        return  view;
    }

    public  void preparaDatos(){
        prod_datos.setCveprod(Integer.valueOf(loc_editCveprod.getText().toString()));
        prod_datos.setNombreprod(loc_editNombreprod.getText().toString());
        prod_datos.setAutorprod(loc_editAutorprod.getText().toString());
        prod_datos.setPrecioprod(Double.valueOf(loc_editPrecioprod.getText().toString()));
        prod_datos.setFotoprod(varfoto);
        prod_datos.setActivo(loc_chkActivo.isChecked());
        prod_datos.setFechacaptura(new Date());
        Log.d("Datos de Productos", "Preparo los datos........................ " + loc_chkActivo.isChecked() );
    }
}