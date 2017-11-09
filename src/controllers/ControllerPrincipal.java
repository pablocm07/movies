/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
    
import java.awt.Dimension;
import models.ModelClientes;
import models.ModelPeliculas;
import models.ModelPrincipal;
import models.ModelRentas;
import views.ViewClientes;
import views.ViewPeliculas;
import views.ViewPrincipal;
import views.ViewRentas;

/**
 *
 * @author tazaz
 */
public class ControllerPrincipal {
    ModelPrincipal model_principal;
    ModelPeliculas model_peliculas;
    ModelClientes model_clientes;
    ModelRentas model_rentas;
    ViewPrincipal view_principal;
    ViewPeliculas view_peliculas;
    ViewClientes view_clientes;        
    ViewRentas view_rentas;        
    
    public ControllerPrincipal(Object models[], Object views[]){
        model_principal = (ModelPrincipal)models[0];
        model_peliculas = (ModelPeliculas)models[1];
        model_clientes = (ModelClientes)models[2];
        model_rentas = (ModelRentas)models[3];
        view_principal = (ViewPrincipal) views[3];
        view_rentas = (ViewRentas) views[2];
        view_peliculas = (ViewPeliculas) views[1];    
        view_clientes = (ViewClientes) views[0];    
        view_principal.jmi_peliculas.addActionListener(e->jmi_peliculas_clic());
        view_principal.jmi_clientes.addActionListener(e->jmi_clientes_clic());                
        view_principal.jmi_rentar.addActionListener(e->jmi_rentar_clic());
        initView();
    }
    public final void initView(){
        view_principal.setVisible(true);
        view_principal.setTitle("Inicio");
        view_principal.setMinimumSize(new Dimension(300, 300));
        view_principal.setSize(new Dimension(300, 300));
        view_principal.setLocationRelativeTo(null);
        view_principal.revalidate();
        view_principal.repaint();
    }    
    public void jmi_clientes_clic(){     
        view_principal.setContentPane(view_clientes);
        view_principal.setMinimumSize(new Dimension(430,320));
        view_principal.setSize(new Dimension(430, 320));
        view_principal.setLocationRelativeTo(null);
        view_principal.revalidate();
        view_principal.repaint();        
    }
    public void jmi_rentar_clic(){     
        view_principal.setContentPane(view_rentas);
        view_principal.setMinimumSize(new Dimension(470,340));
        view_principal.setSize(new Dimension(470, 340));
        view_principal.setLocationRelativeTo(null);
        view_principal.revalidate();
        view_principal.repaint();        
    }
    public void jmi_peliculas_clic(){        
        view_principal.setContentPane(view_peliculas);
        view_principal.setMinimumSize(new Dimension(400,400));
        view_principal.setSize(new Dimension(400,400));
        view_principal.setLocationRelativeTo(null);
        view_principal.revalidate();
        view_principal.repaint();        
    }
}
