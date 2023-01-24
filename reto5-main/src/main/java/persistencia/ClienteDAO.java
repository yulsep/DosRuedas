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
public class ClienteDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List <Cliente> datos = new ArrayList<>();
        String sql="SELECT * FROM clientes";
        try {
            con = Database.Open();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setAlias(rs.getString(1));
                c.setNombre(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setCelular(rs.getString(5));
                c.setContrasena(rs.getString(6));
                c.setF_nacimiento(rs.getString(7));
                datos.add(c);
            }
        } catch (SQLException e) {
        }
        return datos;
    }
    
     public int agregar(Cliente cli) {  
        int r=0;
        String sql="insert into clientes (alias,nombre,apellido,email,celular,contraseña,f_nacimiento)values(?,?,?,?,?,?,?)";
        try {
            con = Database.Open();
            ps = con.prepareStatement(sql);            
            ps.setString(1,cli.getAlias());
            ps.setString(2,cli.getNombre());
            ps.setString(3,cli.getApellidos());
            ps.setString(4,cli.getEmail());
            ps.setString(5,cli.getCelular());
            ps.setString(6,cli.getContrasena());
            ps.setString(7,cli.getF_nacimiento());
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
    public int Actualizar(Cliente cli) {  
        int r=0;
        String sql="update clientes set nombre=?,apellido=?,email=?,celular=?,contraseña=?,f_nacimiento=? where alias=?";
        try {
            con = Database.Open();
            ps = con.prepareStatement(sql);  
            ps.setString(1,cli.getNombre());
            ps.setString(2,cli.getApellidos());
            ps.setString(3,cli.getEmail());
            ps.setString(4,cli.getCelular());
            ps.setString(5,cli.getContrasena());
            ps.setString(6,cli.getF_nacimiento());
            ps.setString(7,cli.getAlias());
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
    public int Delete(String alias){
        int r=0;
        String sql="delete from cliente where alias= '"+ alias +"'";
        try {
            con=Database.Open();
            ps=con.prepareStatement(sql);
            r= ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
}
