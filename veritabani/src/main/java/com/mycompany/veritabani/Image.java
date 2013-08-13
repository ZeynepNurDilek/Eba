/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.veritabani;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import java.util.Map;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name="image")
@ViewScoped


public class Image {

        private String id,baslik,icerik,etiket,resimurl,kategori,param;
        private Date tarih;
        private PreparedStatement st;
	private ResultSet rs;
        List<Image> liste = new ArrayList<Image>();
        private int totalim;
	
        public Image(){
        totalim=0;
        }
        
        public String outcome(){
 
		FacesContext fc = FacesContext.getCurrentInstance();
		this.param = getImageParam(fc);
 
		return this.param;
	}
        
         private String getImageParam(FacesContext fc) {
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("id");
    }
      
        public Image ( String id,String baslik,String icerik,Date tarih,
                String etiket,String resimurl,String kategori){
            this.id=id;
            this.baslik=baslik;
            this.icerik=icerik;
            this.tarih=tarih;
            this.etiket=etiket;
            this.resimurl=resimurl;
            this.kategori=kategori;
           
        }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the baslik
     */
    public String getBaslik() {
        return baslik;
    }

    /**
     * @param baslik the baslik to set
     */
    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    /**
     * @return the icerik
     */
    public String getIcerik() {
        return icerik;
    }

    /**
     * @param icerik the icerik to set
     */
    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    /**
     * @return the tarih
     */
    public Date getTarih() {
        return tarih;
    }

    /**
     * @param tarih the tarih to set
     */
    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    /**
     * @return the etiket
     */
    public String getEtiket() {
        return etiket;
    }

    /**
     * @param etiket the etiket to set
     */
    public void setEtiket(String etiket) {
        this.etiket = etiket;
    }

    /**
     * @return the resimurl
     */
    public String getResimurl() {
        return resimurl;
    }

    /**
     * @param resimurl the resimurl to set
     */
    public void setResimurl(String resimurl) {
        this.resimurl = resimurl;
    }

    /**
     * @return the kategori
     */
    public String getKategori() {
        return kategori;
    }

    /**
     * @param kategori the kategori to set
     */
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
    
     public List<Image> Yazdir(){

		baglan nesne = new baglan();
		

		try {
			st=nesne.getCon().prepareStatement("select * from images");
			rs=st.executeQuery();

			while(rs.next()){
				Image obj = new Image();
			obj.setId(rs.getString("id"));
			obj.setBaslik(rs.getString("baslik"));
			obj.setIcerik(rs.getString("icerik"));
                        obj.setTarih(rs.getTimestamp("tarih"));
			obj.setEtiket(rs.getString("etiket"));
                        obj.setResimurl(rs.getString("resimurl"));
                        obj.setKategori(rs.getString("kategori"));
			setTotalim(getTotalim() + 1);

			this.liste.add(obj);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
                finally{
                    nesne.closeConnection();
                    return this.liste;
                
                }
	}
     
      public Image bul(){

		baglan nesne = new baglan();
		HttpServletRequest request = (HttpServletRequest)FacesContext.
      getCurrentInstance().getExternalContext().getRequest();
                String id=request.getParameter("id");
                Image obj = new Image();
		try {
			st=nesne.getCon().prepareStatement("select * from images where id=?");
                        st.setString(1, id);
      			rs=st.executeQuery();
                        while(rs.next()){
				
			obj.setId(rs.getString("id"));
			obj.setBaslik(rs.getString("baslik"));
			obj.setIcerik(rs.getString("icerik"));
                        obj.setTarih(rs.getTimestamp("tarih"));
			obj.setEtiket(rs.getString("etiket"));
                        obj.setResimurl(rs.getString("resimurl"));
                        obj.setKategori(rs.getString("kategori"));
			
			}
		} catch (Exception e) {
			System.err.println(e);
		}
                finally {
                    nesne.closeConnection();
		return obj;
                }
      }
     
    
     
     /*public Image bul(){
         Image obj=new Image();
         List<Image> deneme= Yazdir();
         
         for(int i=0;i<deneme.size();i++){
             if(deneme.get(i).id==outcome()){
                 obj.setBaslik(deneme.get(i).baslik);
             }
         }
         return obj;
     }*/

    /**
     * @return the totalim
     */
    public int getTotalim() {
        return totalim;
    }

    /**
     * @param totalim the totalim to set
     */
    public void setTotalim(int totalim) {
        this.totalim = totalim;
    }
       
  
 

   
   
        
        
    }
    
    

       




	