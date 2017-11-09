/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.ModelClientes;
import models.ModelRentas;
import views.ViewRentas;

/**
 *
 * @author tazaz
 */
public class ControllerRentas {
    private final ModelRentas model_rentas;    
    private final ViewRentas view_rentas;    
    public ControllerRentas(ModelRentas model_rentas, ViewRentas view_rentas){
        this.model_rentas = model_rentas;
        this.view_rentas = view_rentas;   
        view_rentas.jbtn_nueva_renta.addActionListener(e->jbtn_nueva_renta());
        initView();
    }    
    public void initView(){        
        view_rentas.setVisible(true);                
    }
    public void jbtn_nueva_renta(){          
          model_rentas.conectar();
          view_rentas.jtf_id_renta.setText(model_rentas.getId_renta()+""); 
          view_rentas.jcb_id_cliente.removeAllItems();
          model_rentas.idCliente();
    }    
}
