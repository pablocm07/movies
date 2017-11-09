/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controllers.ControllerClientes;
import controllers.ControllerPeliculas;
import controllers.ControllerPrincipal;
import controllers.ControllerRentas;
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
public class Main {
    public static void main(String pcm[]){
        ModelPeliculas model_peliculas = new ModelPeliculas();
        ViewPeliculas view_peliculas = new ViewPeliculas();
        ControllerPeliculas controller_peliculas = new ControllerPeliculas(model_peliculas,view_peliculas);        
        ModelClientes model_clientes = new ModelClientes();
        ViewClientes view_clientes = new ViewClientes();
        ModelRentas model_rentas = new ModelRentas();
        ViewRentas view_rentas = new ViewRentas();
        ControllerRentas controller_rentas = new ControllerRentas(model_rentas,view_rentas);
        ControllerClientes controllers_clientes = new ControllerClientes(model_clientes,view_clientes);
        ModelPrincipal model_principal = new ModelPrincipal();
        ViewPrincipal view_principal = new ViewPrincipal();
        Object models[] = new Object[4];
        Object views[] = new Object[4];
        models[0]=model_principal;
        models[1]=model_peliculas;
        models[2]=model_clientes;        
        models[3]=model_rentas;        
        views[0]=view_clientes;
        views[1]=view_peliculas;
        views[2]=view_rentas;
        views[3]=view_principal;        
        ControllerPrincipal controller_principal = new ControllerPrincipal(models,views);
    }
}
