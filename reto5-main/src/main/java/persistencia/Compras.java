/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

/**
 *
 * @author User
 */
public class Compras {
    
    int id;
    String alias;
    String fabricante;
    String fecha_hora;

    public Compras() {
    }

    public Compras(int id, String alias, String fabricante, String fecha_hora) {
        this.id = id;
        this.alias = alias;
        this.fabricante = fabricante;
        this.fecha_hora = fecha_hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fechaHora) {
        this.fecha_hora = fechaHora;
    }
    
      
    
}
