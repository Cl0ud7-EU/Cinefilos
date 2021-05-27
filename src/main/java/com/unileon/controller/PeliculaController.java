/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.CompaniaFacadeLocal;
import com.unileon.EJB.PeliculaFacadeLocal;
import com.unileon.EJB.DirectorFacadeLocal;
import com.unileon.modelo.Compania;
import com.unileon.modelo.Director;
import com.unileon.modelo.Pelicula;
import java.io.Serializable;
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
public class PeliculaController implements Serializable{
    private Pelicula pelicula;
    private List<Compania> listacompanias;
    private List<Director> listadirectores;
    private List<Pelicula> listapeliculas;
    @EJB
    private PeliculaFacadeLocal peliculaEJB;
    
    @EJB
    private CompaniaFacadeLocal companiaEJB;
    @EJB
    private DirectorFacadeLocal directorEJB;
    
    @PostConstruct //Se accede después de crear la clase
    public void init(){
        pelicula = new Pelicula();
     
       
        try {
            listadirectores = directorEJB.findAll();
            listacompanias = companiaEJB.findAll();
            listapeliculas = peliculaEJB.findAll();
            //System.out.print(listacompanias.size());
        } catch (Exception e) {
        }
        
    }
    
    public void insertar(){
        try {
            //pelicula.setCompania(compania);
            peliculaEJB.create(pelicula);
        } catch (Exception e) {
        }
      info();
    }
    
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Usted se ha registrado correctamente"));
    }
    
    public Pelicula datos(){ 
        List<Pelicula> lista = peliculaEJB.consultaTodo(1);
        pelicula = lista.get(0);
        return pelicula;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public List<Compania> getListacompanias() {
        return listacompanias;
    }

    public void setListacompanias(List<Compania> listacompanias) {
        this.listacompanias = listacompanias;
    }

    public PeliculaFacadeLocal getPeliculaEJB() {
        return peliculaEJB;
    }

    public void setPeliculaEJB(PeliculaFacadeLocal peliculaEJB) {
        this.peliculaEJB = peliculaEJB;
    }

    public CompaniaFacadeLocal getCompaniaEJB() {
        return companiaEJB;
    }

    public void setCompaniaEJB(CompaniaFacadeLocal companiaEJB) {
        this.companiaEJB = companiaEJB;
    }

    public List<Director> getListadirectores() {
        return listadirectores;
    }

    public void setListadirectores(List<Director> listadirectores) {
        this.listadirectores = listadirectores;
    }

    public DirectorFacadeLocal getDirectorEJB() {
        return directorEJB;
    }

    public void setDirectorEJB(DirectorFacadeLocal directorEJB) {
        this.directorEJB = directorEJB;
    }

    public List<Pelicula> getListapeliculas() {
        return listapeliculas;
    }

    public void setListapeliculas(List<Pelicula> listapeliculas) {
        this.listapeliculas = listapeliculas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.pelicula);
        hash = 43 * hash + Objects.hashCode(this.listacompanias);
        hash = 43 * hash + Objects.hashCode(this.listadirectores);
        hash = 43 * hash + Objects.hashCode(this.listapeliculas);
        hash = 43 * hash + Objects.hashCode(this.peliculaEJB);
        hash = 43 * hash + Objects.hashCode(this.companiaEJB);
        hash = 43 * hash + Objects.hashCode(this.directorEJB);
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
        if (!Objects.equals(this.listacompanias, other.listacompanias)) {
            return false;
        }
        if (!Objects.equals(this.listadirectores, other.listadirectores)) {
            return false;
        }
        if (!Objects.equals(this.listapeliculas, other.listapeliculas)) {
            return false;
        }
        if (!Objects.equals(this.peliculaEJB, other.peliculaEJB)) {
            return false;
        }
        if (!Objects.equals(this.companiaEJB, other.companiaEJB)) {
            return false;
        }
        if (!Objects.equals(this.directorEJB, other.directorEJB)) {
            return false;
        }
        return true;
    }
    
    
    
}
