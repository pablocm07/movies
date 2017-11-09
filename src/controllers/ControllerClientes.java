package controllers;

import models.ModelClientes;
import views.ViewClientes;

public class ControllerClientes {   
    private final ModelClientes model_clientes;
    private final ViewClientes view_clientes;        
    
    public ControllerClientes(ModelClientes model_clientes, ViewClientes view_clientes){
        this.model_clientes = model_clientes;
        this.view_clientes = view_clientes;
        view_clientes.jbtn_nuevo.addActionListener(e->jbtn_nuevo_clic());
        view_clientes.jbtn_agregar.addActionListener(e->jbtn_agregar_clic());
        view_clientes.jbtn_quitar.addActionListener(e->jbtn_quitar_clic());
        view_clientes.jbtn_modificar.addActionListener(e->jbtn_modificar_clic());
        view_clientes.jbtn_anterior.addActionListener(e->jbtn_anterior_clic());
        view_clientes.jbtn_primero.addActionListener(e->jbtn_primero_clic());
        view_clientes.jbtn_siguiente.addActionListener(e->jbtn_siguiente_clic());
        view_clientes.jbtn_ultimo.addActionListener(e->jbtn_ultimo_clic());
        initView();
    }    
    public void initView(){
        model_clientes.conectar();
        view_clientes.setVisible(true);       
        model_clientes.moverPrimero();        
        getValores();
    }
    public void getValores(){              
        view_clientes.jtf_id_cliente.setText(""+model_clientes.getId_cliente());
        view_clientes.jtf_nombre.setText(model_clientes.getNombre());
        view_clientes.jtf_telefono.setText(model_clientes.getTelefono());
        view_clientes.jtf_email.setText(model_clientes.getEmail());                
        view_clientes.jtf_direccion.setText(model_clientes.getDireccion());
    } 
    public void setValores(){
        model_clientes.setId_cliente(Integer.parseInt(view_clientes.jtf_id_cliente.getText()));        
        model_clientes.setNombre(view_clientes.jtf_nombre.getText());
        model_clientes.setTelefono(view_clientes.jtf_telefono.getText());
        model_clientes.setEmail(view_clientes.jtf_email.getText());        
        model_clientes.setDireccion(view_clientes.jtf_direccion.getText());        
    } 
    public void jbtn_nuevo_clic(){
        view_clientes.jtf_id_cliente.setText("");
        view_clientes.jtf_nombre.setText("");
        view_clientes.jtf_telefono.setText("");
        view_clientes.jtf_email.setText("");                
        view_clientes.jtf_direccion.setText("");                
    }
    public void jbtn_agregar_clic(){                
        setValores();                
        model_clientes.insertar(model_clientes.getId_cliente(),model_clientes.getNombre(),model_clientes.getTelefono(),model_clientes.getEmail(),model_clientes.getDireccion());
        getValores();
    }
    public void jbtn_quitar_clic(){
        setValores();
        model_clientes.borrar(model_clientes.getId_cliente());
        getValores();
    }
    public void jbtn_modificar_clic(){        
        setValores();
        model_clientes.actualizar(model_clientes.getId_cliente(), model_clientes.getNombre(), model_clientes.getTelefono(), model_clientes.getEmail(), model_clientes.getDireccion());
        getValores();
    }
    public void jbtn_primero_clic(){
        model_clientes.moverPrimero();
        getValores();
    }
    public void jbtn_siguiente_clic(){
        model_clientes.moverSiguiente();
        getValores();
    }
    public void jbtn_anterior_clic(){
        model_clientes.moverAnterior();
        getValores();
    }
    public void jbtn_ultimo_clic(){
        model_clientes.moverUltimo();
        getValores();
    }
}


