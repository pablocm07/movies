/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import views.ViewRentas;


public class ModelRentas {
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    private int id_renta;
    //ViewRentas vr = new ViewRentas();
    //private int renta;
    
    public int getId_renta(){
        return id_renta;
    }
    public void setId_renta(int id_renta){
        this.id_renta = id_renta;
    }
    public void conectar(){
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost/movies","root","SOCIALempireS20");            
            seleccionarTodos();                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectar con BD: "+ex.getMessage());
        }
    }    
    public void seleccionarTodos(){
        try {
            sql = "SELECT * FROM rentas";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs != null)
                setId_renta(rs.getInt("id_renta")+1);                       
        } catch (SQLException ex) {
            setId_renta(1);           
            //JOptionPane.showMessageDialog(null, "Error seleccionar Todos: "+ex.getMessage());
        }
    }    
    public void idCliente(){                 
        try {  
            sql = "SELECT * FROM clientes";            
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();                      
            while(rs.next()){
                String nom = rs.getString("id_cliente");                
                ViewRentas.jcb_id_cliente.addItem(nom);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ey"+ex.getMessage());
        }
    }
}
