package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ModelPeliculas {
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;     

    private int id_pelicula;
    private String nombre;
    private String formato;
    private String duracion;
    private String descripcion;
    
    public int getId_pelicula(){
        return id_pelicula;
    }
    public void setId_pelicula(int id_pelicula){
        this.id_pelicula = id_pelicula;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getFormato(){
        return formato;
    }
    public void setFormato(String formato){
        this.formato = formato;
    }
    public String getDuracion(){
        return duracion;
    }
    public void setDuracion(String duracion){
        this.duracion = duracion;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
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
            sql = "SELECT * FROM peliculas";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error seleccionarTodos: "+ex.getMessage());
        }
    }
    public void llenarValores(){
        try{            
            setId_pelicula(rs.getInt("id_pelicula"));
            setNombre(rs.getString("nombre"));
            setFormato(rs.getString("formato"));
            setDuracion(rs.getString("duracion"));            
            setDescripcion(rs.getString("descripcion"));
        }catch(SQLException es){
            JOptionPane.showMessageDialog(null,"Error al llenar valores: "+es.getMessage());
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
    public void insertar(int id_pelicula, String nombre, String formato, String duracion, String descripcion){
        try{
            sql = "INSERT INTO peliculas (id_pelicula,nombre,formato,duracion,descripcion)VALUES (?,?,?,?,?);";
            ps = cn.prepareStatement(sql);
            ps.setInt(1,id_pelicula);
            ps.setString(2,nombre);
            ps.setString(3,formato);
            ps.setString(4,duracion);
            ps.setString(5,descripcion);
            ps.executeUpdate();
            conectar();
            moverPrimero();
        }catch(SQLException es){                        
            JOptionPane.showMessageDialog(null,"Error al insertar"+es.getMessage());
        }
    }
    public void borrar(int id_pelicula){
        try{
            sql = "DELETE FROM peliculas WHERE id_pelicula = ?;";
            ps = cn.prepareStatement(sql);
            ps.setInt(1,id_pelicula);
            ps.executeUpdate();            
            conectar();
            moverPrimero();
        }catch(SQLException es){
            JOptionPane.showMessageDialog(null, "Error al borrar: "+es.getMessage());
        }
    }
    public void actualizar(int id_pelicula, String nombre, String formato, String duracion, String descripcion){
        try{                  
            sql = "UPDATE peliculas SET nombre = ?, formato = ?, duracion = ?, descripcion = ? WHERE id_pelicula = ?;";
            ps = cn.prepareStatement(sql);
            ps.setInt(5, id_pelicula);            
            ps.setString(1, nombre);
            ps.setString(2, formato);
            ps.setString(3, duracion);
            ps.setString(4, descripcion);
            ps.executeUpdate();            
            conectar();
            moverPrimero();
            }catch(SQLException es){                
                JOptionPane.showMessageDialog(null, "Error al actualizar"+es.getMessage());
        }           
    }
}
