package controllers;

import models.ModelPeliculas;
import views.ViewPeliculas;

public class ControllerPeliculas {
    private final ModelPeliculas model_peliculas;
    private final ViewPeliculas view_peliculas;        
    
    public ControllerPeliculas(ModelPeliculas model_peliculas, ViewPeliculas view_peliculas){
        this.model_peliculas = model_peliculas;
        this.view_peliculas = view_peliculas;
        view_peliculas.jbtn_nuevo.addActionListener(e->jbtn_nuevo_clic());
        view_peliculas.jbtn_agregar.addActionListener(e->jbtn_agregar_clic());
        view_peliculas.jbtn_quitar.addActionListener(e->jbtn_quitar_clic());
        view_peliculas.jbtn_modificar.addActionListener(e->jbtn_modificar_clic());
        view_peliculas.jbtn_anterior.addActionListener(e->jbtn_anterior_clic());
        view_peliculas.jcb_formato.addActionListener(e->jcb_formato_clic());
        view_peliculas.jbtn_primero.addActionListener(e->jbtn_primero_clic());
        view_peliculas.jbtn_siguiente.addActionListener(e->jbtn_siguiente_clic());
        view_peliculas.jbtn_ultimo.addActionListener(e->jbtn_ultimo_clic());
        initView();
    }    
    public void initView(){
        model_peliculas.conectar();
        view_peliculas.setVisible(true);
        view_peliculas.jcb_formato.setEditable(false);                
        model_peliculas.moverPrimero();        
        System.out.println(model_peliculas.getFormato());
        getValores();
        
    }
    public void getValores(){      
        //view_peliculas.jcb_formato.removeAllItems();
        view_peliculas.jtf_id_pelicula.setText(""+model_peliculas.getId_pelicula());
        view_peliculas.jtf_nombre.setText(model_peliculas.getNombre());                
        view_peliculas.jcb_formato.addItem(model_peliculas.getFormato());
        view_peliculas.jtf_duracion.setText(model_peliculas.getDuracion());                
        view_peliculas.jta_descripcion.setText(model_peliculas.getDescripcion());
    } 
    public void setValores(){                               
        model_peliculas.setId_pelicula(Integer.parseInt(view_peliculas.jtf_id_pelicula.getText()));        
        model_peliculas.setNombre(view_peliculas.jtf_nombre.getText());        
        model_peliculas.setFormato(""+view_peliculas.jcb_formato.getSelectedItem());        
        model_peliculas.setDuracion(view_peliculas.jtf_duracion.getText());        
        model_peliculas.setDescripcion(view_peliculas.jta_descripcion.getText());                
    } 
    public void jbtn_nuevo_clic(){
        view_peliculas.jcb_formato.setEnabled(true);
        view_peliculas.jcb_formato.removeAllItems();
        view_peliculas.jcb_formato.addItem("Blue-Ray");
        view_peliculas.jcb_formato.addItem("DVD");         
        view_peliculas.jtf_id_pelicula.setText("");
        view_peliculas.jtf_nombre.setText("");        
        view_peliculas.jtf_duracion.setText("");                
        view_peliculas.jta_descripcion.setText("");                
    }
    public void jbtn_agregar_clic(){                
        view_peliculas.jcb_formato.setEditable(false);
        setValores();                        
        model_peliculas.insertar(model_peliculas.getId_pelicula(),model_peliculas.getNombre(),model_peliculas.getFormato(),model_peliculas.getDuracion(),model_peliculas.getDescripcion());
        view_peliculas.jcb_formato.removeAllItems();
        getValores();
    }
    public void jbtn_quitar_clic(){
        view_peliculas.jcb_formato.setEditable(false);
        setValores();
        model_peliculas.borrar(model_peliculas.getId_pelicula());
        view_peliculas.jcb_formato.removeAllItems();
        getValores();
    }
    public void jbtn_modificar_clic(){        
        view_peliculas.jcb_formato.setEditable(false);
        setValores();
        model_peliculas.actualizar(model_peliculas.getId_pelicula(),model_peliculas.getNombre(),model_peliculas.getFormato(),model_peliculas.getDuracion(),model_peliculas.getDescripcion());
        view_peliculas.jcb_formato.removeAllItems();
        getValores();
    }
    public void jbtn_primero_clic(){
        view_peliculas.jcb_formato.removeAllItems();
        model_peliculas.moverPrimero();        
        getValores();
    }
    public void jbtn_siguiente_clic(){
        view_peliculas.jcb_formato.removeAllItems();
        model_peliculas.moverSiguiente();        
        getValores();
    }
    public void jbtn_anterior_clic(){
        view_peliculas.jcb_formato.removeAllItems();
        model_peliculas.moverAnterior();        
        getValores();
    }
    public void jbtn_ultimo_clic(){
        view_peliculas.jcb_formato.removeAllItems();
        model_peliculas.moverUltimo();        
        getValores();
    }
    public void jcb_formato_clic(){        
        model_peliculas.setFormato(""+view_peliculas.jcb_formato.getSelectedItem());
    }
}
