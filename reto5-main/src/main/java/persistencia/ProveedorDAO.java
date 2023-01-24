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
public class ProveedorDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List <Proveedor> datos = new ArrayList<>();
        String sql="SELECT * FROM proveedor";
        try {
            con = Database.Open();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()) {
                Proveedor c = new Proveedor();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setDireccion(rs.getString(3));
                c.setTelefono(rs.getString(4));

                datos.add(c);
            }
        } catch (SQLException e) {
        }
        return datos;
    }
    
     public int agregar(Proveedor com) {  
        int r=0;
        String sql="insert into proveedor (prov_id,prov_nombre,prov_direccion,prov_telefono)values(?,?,?,?)";
        try {
            con = Database.Open();
            ps = con.prepareStatement(sql);            
            ps.setInt(1,com.getId());
            ps.setString(2,com.getNombre());
            ps.setString(3,com.getDireccion());
            ps.setString(4,com.getTelefono());
 
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
    public int Actualizar(Proveedor com) {  
        int r=0;
        String sql="update proveedor set prov_nombre=?,prov_direccion=?,prov_telefono=? where prov_id=?";
        try {
            con = Database.Open();
            ps = con.prepareStatement(sql);  
            
            ps.setString(1,com.getNombre());
            ps.setString(2,com.getDireccion());
            ps.setString(3,com.getTelefono());
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
        String sql="delete from proveedor where prov_id= '"+ id +"'";
        try {
            con=Database.Open();
            ps=con.prepareStatement(sql);
            r= ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
}
