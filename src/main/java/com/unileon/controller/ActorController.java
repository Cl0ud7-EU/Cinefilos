/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.ActorFacadeLocal;
import com.unileon.EJB.PeliculaFacadeLocal;
import com.unileon.modelo.Actor;
import com.unileon.modelo.Pelicula;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author jcorral
 */
@Named
@ViewScoped
public class ActorController implements Serializable{
    
    private Actor actor;
    private List<Actor> listaActores;
    
    private Pelicula pelicula;
    @EJB
    private ActorFacadeLocal actorEJB;
    @EJB
    private PeliculaFacadeLocal peliculaEJB;
    
    
    
    @PostConstruct //Se accede después de crear la clase
    public void init(){
        actor = new Actor();
        listaActores = new ArrayList<Actor>();
        pelicula = new Pelicula();
        pelicula = peliculaEJB.peliculaSeleccionada();
        try {
            
            listaActores = actorEJB.findAll();
        } catch (Exception e) {
        }
    }

    public List<Actor> listaActoresPelis() {
        listaActores = actorEJB.findActorPelis(pelicula);
        return listaActores;
    }

    public List<Actor> getListaActores() {
        return listaActores;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public PeliculaFacadeLocal getPeliculaEJB() {
        return peliculaEJB;
    }

    public void setPeliculaEJB(PeliculaFacadeLocal peliculaEJB) {
        this.peliculaEJB = peliculaEJB;
    }

    public void setListaActores(List<Actor> listaActores) {
        this.listaActores = listaActores;
    }
    
    public void insertar(){
        try {
            actorEJB.create(actor);
        } catch (Exception e) {
        }
      info();
    }
    
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Actor insertada correctamente"));
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public ActorFacadeLocal getActorEJB() {
        return actorEJB;
    }

    public void setActorEJB(ActorFacadeLocal actorEJB) {
        this.actorEJB = actorEJB;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.actor);
        hash = 47 * hash + Objects.hashCode(this.actorEJB);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ActorController other = (ActorController) obj;
        if (!Objects.equals(this.actor, other.actor)) {
            return false;
        }
        if (!Objects.equals(this.actorEJB, other.actorEJB)) {
            return false;
        }
        return true;
    }
    
    
}
