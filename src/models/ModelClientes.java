package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import views.ViewRentas;

public class ModelClientes {
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;     
    private int id_cliente;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    
    public int getId_cliente(){
        return id_cliente;
    }
    public void setId_cliente(int id_cliente){
        this.id_cliente = id_cliente;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
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
            sql = "SELECT * FROM clientes";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error seleccionarTodos: "+ex.getMessage());
        }
    }
    public void llenarValores(){
        try{            
            setId_cliente(rs.getInt("id_cliente"));
            setNombre(rs.getString("nombre"));
            setTelefono(rs.getString("telefono"));
            setEmail(rs.getString("email"));            
            setDireccion(rs.getString("direccion"));            
        }catch(SQLException es){
            JOptionPane.showMessageDialog(null,"Ey "+es.getMessage());
        }
    }
    public void moverPrimero(){
        try{            
            rs.first();
            llenarValores();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error en boton mover primero");
        }
    }
    public void moverUltimo(){
        try{
            rs.last();
            llenarValores();
        }catch(SQLException es){
            JOptionPane.showMessageDialog(null, "Error en boton mover ultimo");
        }
    }
    public void moverSiguiente(){
        try{
            if(rs.isLast()==false){
                rs.next();
                llenarValores();}
        }catch(SQLException es){
            JOptionPane.showMessageDialog(null, "Error en boton mover siguiente");
        }
    }
    public void moverAnterior(){
        try{
            if(rs.isFirst()==false){
                rs.previous();
                llenarValores();}
        }catch(SQLException es){
            JOptionPane.showMessageDialog(null, "Error en boton mover anterior");
        }
    }
    public void insertar(int id_cliente, String nombre, String telefono, String email, String direccion){
        try{
            sql = "INSERT INTO clientes (id_cliente,nombre,telefono,email,direccion)VALUES (?,?,?,?,?);";
            ps = cn.prepareStatement(sql);
            ps.setInt(1,id_cliente);
            ps.setString(2,nombre);
            ps.setString(3,telefono);
            ps.setString(4,email);
            ps.setString(5,direccion);
            ps.executeUpdate();
            conectar();
            moverPrimero();
        }catch(SQLException es){                        
            JOptionPane.showMessageDialog(null,"Error al insertar"+es.getMessage());
        }
    }
    public void borrar(int id_persona){
        try{
            sql = "DELETE FROM clientes WHERE id_cliente = ?;";
            ps = cn.prepareStatement(sql);
            ps.setInt(1,id_cliente);
            ps.executeUpdate();            
            conectar();
            moverPrimero();
        }catch(SQLException es){
            JOptionPane.showMessageDialog(null, "Error al borrar: "+es.getMessage());
        }
    }
    public void actualizar(int id_cliente, String nombre, String telefono, String email, String direccion){
        try{                  
            sql = "UPDATE clientes SET nombre = ?, telefono = ?, email = ?, direccion = ? WHERE id_cliente = ?;";
            ps = cn.prepareStatement(sql);
            ps.setInt(5, id_cliente);            
            ps.setString(1, nombre);
            ps.setString(2, telefono);
            ps.setString(3, email);
            ps.setString(4, direccion);
            ps.executeUpdate();            
            conectar();
            moverPrimero();
            }catch(SQLException es){                
                JOptionPane.showMessageDialog(null, "Error al actualizar");
        }           
    }
}