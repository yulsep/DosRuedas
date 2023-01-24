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
public class MotocicletasDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        List<Motocicletas> datos = new ArrayList<>();
        String sql = "SELECT * FROM motocicletas";
        try {
            con = Database.Open();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Motocicletas c = new Motocicletas();
                c.setId(rs.getInt(1));
                c.setFabricante(rs.getString(2));
                c.setPrecio(rs.getInt(3));
                c.setAutonomia(rs.getInt(4));
                c.setProveedor(rs.getString(5));
                
                datos.add(c);
            }
        } catch (SQLException e) {
        }
        return datos;
    }

    public int agregar(Motocicletas moto) {
        int r = 0;
        String sql = "insert into motocicletas (id,fabricante,precio,autonomia,id_prov)values(?,?,?,?,?)";
        try {
            con = Database.Open();
            ps = con.prepareStatement(sql);
            ps.setInt(1, moto.getId());
            ps.setString(2, moto.getFabricante());
            ps.setInt(3, moto.getPrecio());
            ps.setInt(4, moto.getAutonomia());
            ps.setString(5, moto.getProveedor());

            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
        }
        return r;
    }

    public int Actualizar(Motocicletas moto) {
        int r = 0;
        String sql = "update motocicletas set fabricante=?, precio=?, autonomia=?, proveedor=? where id=?";
        try {
            con = Database.Open();
            ps = con.prepareStatement(sql);
            ps.setString(1, moto.getFabricante());
            ps.setInt(2, moto.getPrecio());
            ps.setInt(3, moto.getAutonomia());
            ps.setString(4, moto.getProveedor());
            ps.setInt(5, moto.getId());

            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
        }
        return r;
    }

    public int Delete(int id) {
        int r = 0;
        String sql = "delete from motocicletas where id= " + id;
        try {
            con = Database.Open();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
}
