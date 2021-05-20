/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.PeliculaFacadeLocal;
import com.unileon.modelo.Pelicula;
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
public class PeliculaController implements Serializable{
    private Pelicula pelicula;
    
    @EJB
    private PeliculaFacadeLocal peliculaEJB;
    
    @PostConstruct //Se accede después de crear la clase
    public void init(){
        pelicula = new Pelicula();
    }
    
    public void insertar(){
        try {
            peliculaEJB.create(pelicula);
        } catch (Exception e) {
        }
      info();
    }
    
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Usted se ha registrado correctamente"));
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.pelicula);
        hash = 59 * hash + Objects.hashCode(this.peliculaEJB);
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
        final PeliculaController other = (PeliculaController) obj;
        if (!Objects.equals(this.pelicula, other.pelicula)) {
            return false;
        }
        if (!Objects.equals(this.peliculaEJB, other.peliculaEJB)) {
            return false;
        }
        return true;
    }
    
    
}
