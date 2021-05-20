/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.SerieFacadeLocal;
import com.unileon.modelo.Serie;
import java.io.Serializable;
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
public class SerieController implements Serializable{
    private Serie serie;
    
    @EJB
    private SerieFacadeLocal serieEJB;
    
    @PostConstruct //Se accede después de crear la clase
    public void init(){
        serie = new Serie();
    }
    
    public void insertar(){
        try {
            serieEJB.create(serie);
        } catch (Exception e) {
        }
      info();
    }
    
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Usted se ha registrado correctamente"));
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public SerieFacadeLocal getSerieEJB() {
        return serieEJB;
    }

    public void setSerieEJB(SerieFacadeLocal serieEJB) {
        this.serieEJB = serieEJB;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.serie);
        hash = 23 * hash + Objects.hashCode(this.serieEJB);
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
        final SerieController other = (SerieController) obj;
        if (!Objects.equals(this.serie, other.serie)) {
            return false;
        }
        if (!Objects.equals(this.serieEJB, other.serieEJB)) {
            return false;
        }
        return true;
    }
    
    
}
