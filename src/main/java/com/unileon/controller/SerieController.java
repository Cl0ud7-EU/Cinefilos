/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.CompaniaFacadeLocal;
import com.unileon.EJB.SerieFacadeLocal;
import com.unileon.modelo.Compania;
import com.unileon.modelo.Serie;
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
public class SerieController implements Serializable{
    private Serie serie;
    private List<Serie> listaseries;
    private List<Serie> listaSerie;
    private Compania compania;
    
    @EJB
    private CompaniaFacadeLocal companiaEJB;
    @EJB
    private SerieFacadeLocal serieEJB;
    
    @PostConstruct //Se accede después de crear la clase
    public void init(){
        serie = new Serie();
        compania = new Compania();
        serie.setCompania(compania);
        listaSerie = new ArrayList<Serie>();
        
        try {
            listaseries = serieEJB.findAll();
        } catch (Exception e) {
        }
        
        if(listaseries.size()>=5){
            for (int i = listaseries.size()-1; i < listaseries.size()-6; i--) {
                listaSerie.add(listaseries.get(i));
            }
        } else {
            for (int i = 0; i < listaseries.size(); i++) {
                listaSerie.add(listaseries.get(i));
            }
        }
    }
    
    public void insertar(){
        try {
            serieEJB.create(serie);
        } catch (Exception e) {
        }
      info();
    }
    
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Serie insertada correctamente"));
    }
    
     public Serie datos(){ 
        serie = serieEJB.serieSeleccionada();
        return serie;
    }
    
    public String cambioPagina(Serie serie){
        serieEJB.seleccionarSerie(serie.getId());
        return "serie.softwareII";
    }
    
    public String rutaPortada(int id){
        String ruta = "../resources/imagenes/series/"+id+".jpg";
        return ruta;
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

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    public CompaniaFacadeLocal getCompaniaEJB() {
        return companiaEJB;
    }

    public void setCompaniaEJB(CompaniaFacadeLocal companiaEJB) {
        this.companiaEJB = companiaEJB;
    }

    public List<Serie> getListaseries() {
        return listaseries;
    }

    public void setListaseries(List<Serie> listaseries) {
        this.listaseries = listaseries;
    }

    public List<Serie> getListaSerie() {
        return listaSerie;
    }

    public void setListaSerie(List<Serie> listaSerie) {
        this.listaSerie = listaSerie;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.serie);
        hash = 53 * hash + Objects.hashCode(this.listaseries);
        hash = 53 * hash + Objects.hashCode(this.listaSerie);
        hash = 53 * hash + Objects.hashCode(this.compania);
        hash = 53 * hash + Objects.hashCode(this.companiaEJB);
        hash = 53 * hash + Objects.hashCode(this.serieEJB);
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
        if (!Objects.equals(this.listaseries, other.listaseries)) {
            return false;
        }
        if (!Objects.equals(this.listaSerie, other.listaSerie)) {
            return false;
        }
        if (!Objects.equals(this.compania, other.compania)) {
            return false;
        }
        if (!Objects.equals(this.companiaEJB, other.companiaEJB)) {
            return false;
        }
        if (!Objects.equals(this.serieEJB, other.serieEJB)) {
            return false;
        }
        return true;
    }

}
