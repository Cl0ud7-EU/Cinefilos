/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.ComentarioFacadeLocal;
import com.unileon.modelo.Comentario;
import com.unileon.modelo.Pelicula;
import com.unileon.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Cl0ud7
 */
@Named
@ApplicationScoped
public class ComentarioController implements Serializable{
    private Comentario comentario;
    private Pelicula pelicula;
    private Usuario usuario;
    private List<Comentario> comentarios;
    
    @EJB
    private ComentarioFacadeLocal comentarioEJB;
    
    @PostConstruct //Se accede después de crear la clase
    public void init(){
        comentarios = new ArrayList<Comentario>();
        comentario = new Comentario();
        pelicula = new Pelicula();
        usuario = new Usuario();
        comentario.setPelicula(pelicula);
        comentario.setUsuario(usuario);
        pelicula = (Pelicula) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("pelicula");
       
        
        //
        
    }
    
    public void insertar(){
            
            usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            pelicula = (Pelicula) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("pelicula");
            
            comentario.getPelicula().setId(pelicula.getId());
            comentario.getUsuario().setId(usuario.getId());
            
        try {
            comentarioEJB.create(comentario);
        } catch (Exception e) {
        }
    }
    public List<Comentario> listaComentarios() {
        pelicula = (Pelicula) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("pelicula");
        
        comentarios = comentarioEJB.consultaTodo(pelicula);
        return comentarios;
    } 
    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
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
