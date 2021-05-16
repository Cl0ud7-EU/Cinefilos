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
   
   @Column(name="comentario")
   private String comentario;
   
   @JoinColumn(name="idUsuario")
   @ManyToOne
   private String idUsuario;
   
   @JoinColumn(name="idPelicula")
   @ManyToOne
   private String idPelicula;

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

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(String idPelicula) {
        this.idPelicula = idPelicula;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.comentario);
        hash = 47 * hash + Objects.hashCode(this.idUsuario);
        hash = 47 * hash + Objects.hashCode(this.idPelicula);
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
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        if (!Objects.equals(this.idPelicula, other.idPelicula)) {
            return false;
        }
        return true;
    }
   
   
}
