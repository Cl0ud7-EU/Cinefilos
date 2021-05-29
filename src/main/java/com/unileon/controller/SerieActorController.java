/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.SerieActorFacadeLocal;
import com.unileon.modelo.Actor;
import com.unileon.modelo.Serie;
import com.unileon.modelo.SerieActor;
import java.io.Serializable;
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
public class SerieActorController implements Serializable {
    
    private SerieActor serieActor;
    private Actor actor;
    private Serie serie;
    
    @EJB
    private SerieActorFacadeLocal serieActorEJB;
    
    @PostConstruct //Se accede después de crear la clase
    public void init(){
        serieActor = new SerieActor();
        actor = new Actor();
        serie = new Serie();
        
        serieActor.setActor(actor);
        serieActor.setSerie(serie);
        try {
            
        } catch (Exception e) {
        }
    }
    public void insertar(){
        try {
         
            serieActorEJB.create(serieActor);
        } catch (Exception e) {
        }
      info();
    }
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Actor en Serie insertado correctamente"));
    }

    public SerieActor getSerieActor() {
        return serieActor;
    }

    public void setSerieActor(SerieActor serieActor) {
        this.serieActor = serieActor;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public SerieActorFacadeLocal getSerieActorEJB() {
        return serieActorEJB;
    }

    public void setSerieActorEJB(SerieActorFacadeLocal serieActorEJB) {
        this.serieActorEJB = serieActorEJB;
    }
    
    
}
