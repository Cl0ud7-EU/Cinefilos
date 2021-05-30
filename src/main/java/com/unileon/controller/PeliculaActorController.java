/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;


import com.unileon.EJB.PeliculaActorFacadeLocal;
import com.unileon.modelo.Actor;
import com.unileon.modelo.Pelicula;
import com.unileon.modelo.PeliculaActor;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Cl0ud7
 */
@Named
@ViewScoped
public class PeliculaActorController implements Serializable{
    
    private PeliculaActor peliculaActor;
    private Actor actor;
    private Pelicula pelicula;
    
    @EJB
    private PeliculaActorFacadeLocal peliculaActorEJB;
    
    @PostConstruct //Se accede después de crear la clase
    public void init(){
        peliculaActor = new PeliculaActor();
        actor = new Actor();
        pelicula = new Pelicula();
        
        peliculaActor.setActor(actor);
        peliculaActor.setPelicula(pelicula);
        try {
            
        } catch (Exception e) {
        }
    }
    
    public void insertar(){
        try {
         
            peliculaActorEJB.create(peliculaActor);
        } catch (Exception e) {
        }
      info();
    }

    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Actor en Pelicula insertado correctamente"));
    }

    public PeliculaActor getPeliculaActor() {
        return peliculaActor;
    }

    public void setPeliculaActor(PeliculaActor peliculaActor) {
        this.peliculaActor = peliculaActor;
    }

    public PeliculaActorFacadeLocal getPeliculaActorEJB() {
        return peliculaActorEJB;
    }

    public void setPeliculaActorEJB(PeliculaActorFacadeLocal peliculaActorEJB) {
        this.peliculaActorEJB = peliculaActorEJB;
    }
    
}
