/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.veritabani;

/**
 *
 * @author tolga
 */
import java.sql.*;

public class baglan
{
    private Connection _con;
    private String _dbname="eba_proje"; //veritabanı adımız
    private String _dbusername="root"; //Veritabanı kullanıcı adımız
    private String _dbpassword="080808"; //veritabanı şifremiz
    private String _host="jdbc:mysql://127.0.0.1:3306/";
    private String _drivername="com.mysql.jdbc.Driver";

    //Bağlantı için gereken connection ın oluşturulduğu metod
    public baglan()
    {
        try {
         Class.forName(_drivername).newInstance();
        setCon((Connection)DriverManager.getConnection(_host+ _dbname,_dbusername,_dbpassword));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public Connection getCon() {
        return _con;
    }
    public void setCon(Connection _con) {
        this._con = _con;
    }
    
    public void closeConnection (){
        try{
            if(_con!=null && !_con.isClosed())
                _con.close();
        }
        catch (Exception e )
        {}
    }
    
    
}