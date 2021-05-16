/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.ComentarioFacadeLocal;
import com.unileon.modelo.Comentario;
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
public class ComentarioController implements Serializable{
    private Comentario comentario;
    
    @EJB
    private ComentarioFacadeLocal comentarioEJB;
    
    @PostConstruct //Se accede después de crear la clase
    public void init(){
        comentario = new Comentario();
    }
    
    public void insertar(){
        try {
            comentarioEJB.create(comentario);
        } catch (Exception e) {
        }
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public ComentarioFacadeLocal getComentarioEJB() {
        return comentarioEJB;
    }

    public void setComentarioEJB(ComentarioFacadeLocal comentarioEJB) {
        this.comentarioEJB = comentarioEJB;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.comentario);
        hash = 13 * hash + Objects.hashCode(this.comentarioEJB);
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
        final ComentarioController other = (ComentarioController) obj;
        if (!Objects.equals(this.comentario, other.comentario)) {
            return false;
        }
        if (!Objects.equals(this.comentarioEJB, other.comentarioEJB)) {
            return false;
        }
        return true;
    }
    
}
