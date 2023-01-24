/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author William Rojas
 * @author Yuliana Sepúlveda
 */
public class ComprasDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List <Compras> datos = new ArrayList<>();
        String sql="SELECT * FROM compras";
        try {
            con = Database.Open();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()) {
                Compras c = new Compras();
                c.setId(rs.getInt(1));
                c.setAlias(rs.getString(2));
                c.setFabricante(rs.getString(3));
                c.setFecha_hora(rs.getString(4));

                datos.add(c);
            }
        } catch (SQLException e) {
        }
        return datos;
    }
    
     public int agregar(Compras com) {  
        int r=0;
        String sql="insert into compras (id,alias,fabricante,fecha_hora)values(?,?,?,?)";
        try {
            con = Database.Open();
            ps = con.prepareStatement(sql);            
            ps.setInt(1,com.getId());
            ps.setString(2,com.getAlias());
            ps.setString(3,com.getFabricante());
            ps.setString(4,com.getFecha_hora());
 
            r=ps.executeUpdate();    
            if(r==1){
                return 1;
            }
            else{
                return 0;
            }
        } catch (SQLException e) {
        }  
        return r;
    }
    public int Actualizar(Compras com) {  
        int r=0;
        String sql="update compras set alias=?,fabricante=?,fecha_hora=? where id=?";
        try {
            con = Database.Open();
            ps = con.prepareStatement(sql);  
            
            ps.setString(1,com.getAlias());
            ps.setString(2,com.getFabricante());
            ps.setString(3,com.getFecha_hora());
            ps.setInt(4,com.getId());

            r=ps.executeUpdate();    
            if(r==1){
                return 1;
            }
            else{
                return 0;
            }
        } catch (SQLException e) {
        }  
        return r;
    }
    public int Delete(int id){
        int r=0;
        String sql="delete from compras where id= '"+ id +"'";
        try {
            con=Database.Open();
            ps=con.prepareStatement(sql);
            r= ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
}
