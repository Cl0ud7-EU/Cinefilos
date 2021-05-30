/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author Cl0ud7
 */
@Entity(name = "PeliculaActor")
@Table(name="pelicula_actor")
public class PeliculaActor implements Serializable {

    @EmbeddedId
    private PeliculaActorKey id;
    
    @ManyToOne
    @MapsId("IdActor")//Esto corresponde al nombre que le hemos dado en PeliculaActorKey
    @JoinColumn(name = "IdActor")
    private Actor actor;
    
    @ManyToOne
    @MapsId("IdPelicula")
    @JoinColumn(name = "IdPelicula")
    private Pelicula pelicula;

    public PeliculaActorKey getId() {
        return id;
    }

    public void setId(PeliculaActorKey id) {
        this.id = id;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
          
    
    
    
}
