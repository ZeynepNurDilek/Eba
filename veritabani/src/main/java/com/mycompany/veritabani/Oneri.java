/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.veritabani;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author zeynep
 */

@ManagedBean(name="oneri")
@ViewScoped

public class Oneri {
    private String s_id,s_baslik,s_icerik,s_etiket,s_kategori,kayit_id, kabul_sayisi,red_sayisi ,param;
        private PreparedStatement st;
	private ResultSet rs;
        List<Image> liste = new ArrayList<Image>();
       
        public String outcome(){
 
		FacesContext fc = FacesContext.getCurrentInstance();
		this.setParam(getImageParam(fc));
 
		return this.getParam();
	}
       
       private String getImageParam(FacesContext fc) {
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("id");
    }
       
        public Oneri ( String id,String baslik,String icerik,String etiket,String kategori,String kayit_id, String kabul_sayisi, String red_sayisi)
        {
            this.s_id=id;
            this.s_baslik=baslik;
            this.s_icerik=icerik;
            this.s_etiket=etiket;
            this.s_kategori=kategori;
            this.kayit_id=kayit_id;
            this.kabul_sayisi=kabul_sayisi;
            this.red_sayisi=red_sayisi;
            
        }

    /**
     * @return the s_id
     */
    public String getS_id() {
        return s_id;
    }

    /**
     * @param s_id the s_id to set
     */
    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    /**
     * @return the s_baslik
     */
    public String getS_baslik() {
        return s_baslik;
    }

    /**
     * @param s_baslik the s_baslik to set
     */
    public void setS_baslik(String s_baslik) {
        this.s_baslik = s_baslik;
    }

    /**
     * @return the s_icerik
     */
    public String getS_icerik() {
        return s_icerik;
    }

    /**
     * @param s_icerik the s_icerik to set
     */
    public void setS_icerik(String s_icerik) {
        this.s_icerik = s_icerik;
    }

    /**
     * @return the s_etiket
     */
    public String getS_etiket() {
        return s_etiket;
    }

    /**
     * @param s_etiket the s_etiket to set
     */
    public void setS_etiket(String s_etiket) {
        this.s_etiket = s_etiket;
    }

    /**
     * @return the s_kategori
     */
    public String getS_kategori() {
        return s_kategori;
    }

    /**
     * @param s_kategori the s_kategori to set
     */
    public void setS_kategori(String s_kategori) {
        this.s_kategori = s_kategori;
    }

    /**
     * @return the kayit_id
     */
    public String getKayit_id() {
        return kayit_id;
    }

    /**
     * @param kayit_id the kayit_id to set
     */
    public void setKayit_id(String kayit_id) {
        this.kayit_id = kayit_id;
    }

    /**
     * @return the kabul_sayisi
     */
    public String getKabul_sayisi() {
        return kabul_sayisi;
    }

    /**
     * @param kabul_sayisi the kabul_sayisi to set
     */
    public void setKabul_sayisi(String kabul_sayisi) {
        this.kabul_sayisi = kabul_sayisi;
    }

    /**
     * @return the red_sayisi
     */
    public String getRed_sayisi() {
        return red_sayisi;
    }

    /**
     * @param red_sayisi the red_sayisi to set
     */
    public void setRed_sayisi(String red_sayisi) {
        this.red_sayisi = red_sayisi;
    }

    /**
     * @return the param
     */
    public String getParam() {
        return param;
    }

    /**
     * @param param the param to set
     */
    public void setParam(String param) {
        this.param = param;
    }
    
    
}
