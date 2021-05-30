/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.PeliculaGeneroFacadeLocal;
import com.unileon.modelo.Genero;
import com.unileon.modelo.Pelicula;
import com.unileon.modelo.PeliculaGenero;
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
public class PeliculaGeneroController implements Serializable {
    
    private PeliculaGenero peliculaGenero;
    private Pelicula pelicula;
    private Genero genero;
    
    @EJB
    private PeliculaGeneroFacadeLocal peliculaGeneroEJB;
    
    @PostConstruct //Se accede después de crear la clase
    public void init(){
        peliculaGenero = new PeliculaGenero();
        genero = new Genero();
        pelicula = new Pelicula();
        
        peliculaGenero.setGenero(genero);
        peliculaGenero.setPelicula(pelicula);
        try {
            
        } catch (Exception e) {
        }
    }
    
    public void insertar(){
        try {
         
            peliculaGeneroEJB.create(peliculaGenero);
        } catch (Exception e) {
        }
      info();
    }
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Genero insertado en Pelicula"));
    }

    public PeliculaGenero getPeliculaGenero() {
        return peliculaGenero;
    }

    public void setPeliculaGenero(PeliculaGenero peliculaGenero) {
        this.peliculaGenero = peliculaGenero;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public PeliculaGeneroFacadeLocal getPeliculaGeneroEJB() {
        return peliculaGeneroEJB;
    }

    public void setPeliculaGeneroEJB(PeliculaGeneroFacadeLocal peliculaGeneroEJB) {
        this.peliculaGeneroEJB = peliculaGeneroEJB;
    }
    
    
}
