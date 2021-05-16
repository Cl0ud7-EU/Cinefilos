/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.GeneroFacadeLocal;
import com.unileon.modelo.Genero;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Cl0ud7
 */
@Named
@ViewScoped
public class GeneroController implements Serializable{
    private Genero genero;
    
    @EJB
    private GeneroFacadeLocal generoEJB;
    
    @PostConstruct //Se accede después de crear la clase
    public void init(){
        genero = new Genero();
    }
    
    public void insertar(){
        try {
            generoEJB.create(genero);
        } catch (Exception e) {
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.genero);
        hash = 53 * hash + Objects.hashCode(this.generoEJB);
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
        final GeneroController other = (GeneroController) obj;
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.generoEJB, other.generoEJB)) {
            return false;
        }
        return true;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public GeneroFacadeLocal getGeneroEJB() {
        return generoEJB;
    }

    public void setGeneroEJB(GeneroFacadeLocal generoEJB) {
        this.generoEJB = generoEJB;
    }
    
    
    
    
}