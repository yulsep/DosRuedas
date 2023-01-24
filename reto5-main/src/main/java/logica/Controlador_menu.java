/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import igu.Pantalla_menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import persistencia.Cliente;
import persistencia.ClienteDAO;

/**
 *
 * @author William Rojas
 * @author Yuliana Sepúlveda
 */
public class Controlador_menu implements ActionListener{

    ClienteDAO dao = new ClienteDAO();
    Cliente p = new Cliente();
    Pantalla_menu vista = new Pantalla_menu();
    DefaultTableModel modelo = new DefaultTableModel();

    public Controlador_menu(Pantalla_menu v) {
        this.vista = v;
       // this.vista.btnListar.addActionListener(this);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
             /*if (e.getSource() == vista.btnListar) {
            limpiarTabla();
            listar(vista.tabla);
    }*/
    }
    
     /*  public void listar(JTable tabla) {
        centrarCeldas(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Cliente> lista = dao.listar();
        Object[] objeto = new Object[7];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getAlias();
            objeto[1] = lista.get(i).getNombre();
            objeto[2] = lista.get(i).getApellidos();
            objeto[3] = lista.get(i).getEmail();
            objeto[4] = lista.get(i).getCelular();
            objeto[5] = lista.get(i).getContrasena();
            objeto[6] = lista.get(i).getF_nacimiento();
            modelo.addRow(objeto);
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);

    }
       
    void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < vista.tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
     }
    
        void limpiarTabla() {
        for (int i = 0; i < vista.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }*/

    
}
