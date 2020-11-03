package com.example.controllibros_;
import java.util.Date;

public class Producto {
    private int cveprod;
    private String nombreprod;
    private String autorprod;
    private double precioprod;
    private String fotoprod;
    private Date fechacaptura;
    private boolean activo;
    private String campos;
    private String tabla;

    public Producto() {
    }

    public Producto(int cveprod, String nombreprod, String autorprod, double precioprod, String fotoprod, Date fechacaptura, boolean activo) {
        this.cveprod = cveprod;
        this.nombreprod = nombreprod;
        this.autorprod = autorprod;
        this.precioprod = precioprod;
        this.fotoprod = fotoprod;
        this.fechacaptura = fechacaptura;
        this.activo = activo;
    }

    public int getCveprod() {
        return cveprod;
    }

    public void setCveprod(int cveprod) {
        this.cveprod = cveprod;
    }

    public String getNombreprod() {
        return nombreprod;
    }

    public void setNombreprod(String nombreprod) {
        this.nombreprod = nombreprod;
    }

    public String getAutorprod() {
        return autorprod;
    }

    public void setAutorprod(String autorprod) {
        this.autorprod = autorprod;
    }

    public double getPrecioprod() {
        return precioprod;
    }

    public void setPrecioprod(double precioprod) {
        this.precioprod = precioprod;
    }

    public String getFotoprod() {
        return fotoprod;
    }

    public void setFotoprod(String fotoprod) {
        this.fotoprod = fotoprod;
    }

    public Date getFechacaptura() {
        return fechacaptura;
    }

    public void setFechacaptura(Date fechacaptura) {
        this.fechacaptura = fechacaptura;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getTabla(){
        this.tabla="producto";
        return tabla;
    }

    public String getCampos(){
        this.campos= "cveprod Integer primary key, " +
                "nombreprod Text, " +
                "autorprod Text, " +
                "precioprod Text, " +
                "fotoprod Text, " +
                "fechacaptura Text, " +
                "activo Integer ";
        return campos;
    }
}
