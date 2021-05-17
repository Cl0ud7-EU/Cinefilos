/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.CompaniaFacadeLocal;
import com.unileon.modelo.Compania;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author jcorral
 */
@Named
@ViewScoped
public class CompaniaController implements Serializable{
        
    private Compania compania;
    @EJB
    private CompaniaFacadeLocal directorEJB;
    
    @PostConstruct //Se accede después de crear la clase
    public void init(){
        compania = new Compania();
    }
    
    public void insertar(){
        try {
            directorEJB.create(compania);
        } catch (Exception e) {
        }
    }  

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    public CompaniaFacadeLocal getDirectorEJB() {
        return directorEJB;
    }

    public void setDirectorEJB(CompaniaFacadeLocal directorEJB) {
        this.directorEJB = directorEJB;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.compania);
        hash = 83 * hash + Objects.hashCode(this.directorEJB);
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
        final CompaniaController other = (CompaniaController) obj;
        if (!Objects.equals(this.compania, other.compania)) {
            return false;
        }
        if (!Objects.equals(this.directorEJB, other.directorEJB)) {
            return false;
        }
        return true;
    }
    
    
}
