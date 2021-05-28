/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Cl0ud7
 */
@Entity
@Table(name="Comentario")
public class Comentario implements Serializable{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) //Hace que se autoincremente y le asocia el valor de tal forma que lo que cambiemos aquí se cambia en la BBDD
   private int id;
   
   @Column(name="Comentario")
   private String comentario;
   
   @JoinColumn(name="IdUsuario")
   @ManyToOne
   private Usuario usuario;
   
   @JoinColumn(name="IdPelicula")
   @ManyToOne
   private Pelicula pelicula;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.comentario);
        hash = 71 * hash + Objects.hashCode(this.usuario);
        hash = 71 * hash + Objects.hashCode(this.pelicula);
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
        final Comentario other = (Comentario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.comentario, other.comentario)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.pelicula, other.pelicula)) {
            return false;
        }
        return true;
    }

    
   
}
