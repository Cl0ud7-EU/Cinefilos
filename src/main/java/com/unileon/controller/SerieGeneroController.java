/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.SerieGeneroFacadeLocal;
import com.unileon.modelo.Genero;
import com.unileon.modelo.Serie;
import com.unileon.modelo.SerieGenero;
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
public class SerieGeneroController implements Serializable {
    
    private SerieGenero serieGenero;
    private Genero genero;
    private Serie serie;
    
    @EJB
    private SerieGeneroFacadeLocal serieGeneroEJB;
    
    @PostConstruct //Se accede después de crear la clase
    public void init(){
        serieGenero = new SerieGenero();
        genero = new Genero();
        serie = new Serie();
        
        serieGenero.setGenero(genero);
        serieGenero.setSerie(serie);
        try {
            
        } catch (Exception e) {
        }
    }
    public void insertar(){
        try {
         
            serieGeneroEJB.create(serieGenero);
        } catch (Exception e) {
        }
      info();
    }
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Genero en Serie insertado correctamente"));
    }

    public SerieGenero getSerieGenero() {
        return serieGenero;
    }

    public void setSerieGenero(SerieGenero serieGenero) {
        this.serieGenero = serieGenero;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public SerieGeneroFacadeLocal getSerieGeneroEJB() {
        return serieGeneroEJB;
    }

    public void setSerieGeneroEJB(SerieGeneroFacadeLocal serieGeneroEJB) {
        this.serieGeneroEJB = serieGeneroEJB;
    }
    
    
    
}
