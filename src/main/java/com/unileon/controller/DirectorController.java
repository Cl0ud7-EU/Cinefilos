/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.DirectorFacadeLocal;
import com.unileon.modelo.Director;
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
public class DirectorController implements Serializable{
    
    private Director director;
    private List<Director> listadirectores;
    private List<Director> listaDirectores;
    @EJB
    private DirectorFacadeLocal directorEJB;
    
    @PostConstruct //Se accede después de crear la clase
    public void init(){
        director = new Director();
        listaDirectores = new ArrayList<Director>();
        try {
            listadirectores = directorEJB.findAll();
        } catch (Exception e) {
        }
        
        if(listadirectores.size()>=5){
            for (int i = listadirectores.size()-1; i < listadirectores.size()-6; i--) {
                listaDirectores.add(listadirectores.get(i));
            }
        } else {
            for (int i = 0; i < listadirectores.size(); i++) {
                listaDirectores.add(listadirectores.get(i));
            }
        }
    }
    
    public void insertar(){
        try {
            directorEJB.create(director);
        } catch (Exception e) {
        }
      info();
    }
    
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Director insertado correctamente"));
    } 
    
    public Director datos(){ 
        director = directorEJB.directorSeleccionado();
        return director;
    }
    
    public String cambioPagina(Director director){
        directorEJB.seleccionarDirector(director.getId());
        return "director.softwareII";
    }
    
    public String rutaPortada(int id){
        String ruta = "../resources/imagenes/directores/"+id+".jpg";
        return ruta;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public DirectorFacadeLocal getDirectorEJB() {
        return directorEJB;
    }

    public void setDirectorEJB(DirectorFacadeLocal directorEJB) {
        this.directorEJB = directorEJB;
    }

    public List<Director> getListadirectores() {
        return listadirectores;
    }

    public void setListadirectores(List<Director> listadirectores) {
        this.listadirectores = listadirectores;
    }

    public List<Director> getListaDirectores() {
        return listaDirectores;
    }

    public void setListaDirectores(List<Director> listaDirectores) {
        this.listaDirectores = listaDirectores;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.director);
        hash = 23 * hash + Objects.hashCode(this.directorEJB);
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
        final DirectorController other = (DirectorController) obj;
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.directorEJB, other.directorEJB)) {
            return false;
        }
        return true;
    }
    
    
}
