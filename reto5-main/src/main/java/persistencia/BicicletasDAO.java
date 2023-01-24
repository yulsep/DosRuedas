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
public class BicicletasDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        List<Bicicletas> datos = new ArrayList<>();
        String sql = "SELECT * FROM bicicletas";
        try {
            con = Database.Open();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Bicicletas c = new Bicicletas();
                c.setId(rs.getInt(1));
                c.setFabricante(rs.getString(2));
                c.setPrecio(rs.getInt(3));
                c.setAnio(rs.getInt(4));
                datos.add(c);
            }
        } catch (SQLException e) {
        }
        return datos;
    }

    public int agregar(Bicicletas bike) {
        int r = 0;
        String sql = "insert into bicicletas (id,fabricante,precio,anio)values(?,?,?,?)";
        try {
            con = Database.Open();
            ps = con.prepareStatement(sql);
            ps.setInt(1, bike.getId());
            ps.setString(2, bike.getFabricante());
            ps.setInt(3, bike.getPrecio());
            ps.setInt(4, bike.getAnio());

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

    public int Actualizar(Bicicletas bike) {
        int r = 0;
        String sql = "update bicicletas set Fabricante=?, Precio=?, Anio=? where id=?";
        try {
            con = Database.Open();
            ps = con.prepareStatement(sql);
            ps.setString(1, bike.getFabricante());
            ps.setInt(2, bike.getPrecio());
            ps.setInt(3, bike.getAnio());
            ps.setInt(4, bike.getId());

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
        String sql = "delete from bicicletas where id= " + id;
        try {
            con = Database.Open();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
}
