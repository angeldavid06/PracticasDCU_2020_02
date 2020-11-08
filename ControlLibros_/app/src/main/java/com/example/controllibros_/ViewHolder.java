package com.example.controllibros_;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    ImageView loc_imgViewProd;
    TextView loc_textVProd, loc_textVPrecio, getLoc_textVAutor;
    int id;

    public ViewHolder () {}

    public ImageView getLoc_imgViewProd() {
        return loc_imgViewProd;
    }

    public void setLoc_imgViewProd(ImageView loc_imgViewProd) {
        this.loc_imgViewProd = loc_imgViewProd;
    }

    public TextView getLoc_textVProd() {
        return loc_textVProd;
    }

    public void setLoc_textVProd(TextView loc_textVProd) {
        this.loc_textVProd = loc_textVProd;
    }

    public TextView getLoc_textVPrecio() {
        return loc_textVPrecio;
    }

    public void setLoc_textVPrecio(TextView loc_textVPrecio) {
        this.loc_textVPrecio = loc_textVPrecio;
    }

    public TextView getGetLoc_textVAutor() {
        return getLoc_textVAutor;
    }

    public void setGetLoc_textVAutor(TextView getLoc_textVAutor) {
        this.getLoc_textVAutor = getLoc_textVAutor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
