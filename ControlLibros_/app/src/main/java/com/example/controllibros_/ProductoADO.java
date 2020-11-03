package com.example.controllibros_;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductoADO {

    private Context ourcontext;
    private SQLiteDatabase database;
    private DBhelper dbhelper;
    Producto ObjProd;

    public ProductoADO() {    }

    public ArrayList<Producto> llenaProd() throws SQLException {
        ArrayList<Producto> loc_arrayProd = new ArrayList<>();
        dbhelper = new DBhelper(ourcontext);
        database = dbhelper.getReadableDatabase();
        String strQry = "Select cveprod, nombreprod, autorprod, precioprod, fotoprod from producto where activo = 1";
        Cursor c = database.rawQuery(strQry, null);
        loc_arrayProd.clear();
        while (c.moveToNext()) {
            ObjProd = new Producto();
            ObjProd.setCveprod(c.getInt(0));
            ObjProd.setNombreprod(c.getString(1));
            ObjProd.setAutorprod(c.getString(2));
            ObjProd.setPrecioprod(c.getDouble(3));
            ObjProd.setFotoprod(c.getString(4));
            loc_arrayProd.add(ObjProd);
        }
        return loc_arrayProd;
    }

    public ProductoADO(Context c){
        ourcontext= c;
    }

    public ProductoADO abrirBD()throws SQLException {
        dbhelper= new DBhelper(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }


    public void cerrarBD(){
        dbhelper.close();
    }


    public long insertarProducto(Producto prod)throws SQLException{
        int sts=0;
        ContentValues registro = new ContentValues();
        long  result=1;
        registro.put("cveprod", prod.getCveprod());
        registro.put("nombreprod", prod.getNombreprod());
        registro.put("autorprod", prod.getAutorprod());
        registro.put("precioprod", prod.getPrecioprod());
        registro.put("fotoprod", prod.getFotoprod());
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String hoy =formato.format(prod.getFechacaptura());
        registro.put("fechacaptura", hoy);
        if(prod.isActivo()) {
            sts=1;
        }
        registro.put("activo", sts);
        result = database.insert(prod.getTabla(),null,registro);
        Log.d("VALORES INSERTADOS=", String.valueOf(result));
        return result;
    }
}
