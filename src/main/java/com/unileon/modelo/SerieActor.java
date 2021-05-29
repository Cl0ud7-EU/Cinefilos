/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.modelo;

import java.io.Serializable;
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
@Entity(name = "SerieActor")
@Table(name="serie_actor")
public class SerieActor implements Serializable{
    
    @EmbeddedId
    private SerieActorKey id;
    
    @ManyToOne
    @MapsId("IdActor")//Esto corresponde al nombre que le hemos dado en PeliculaActorKey
    @JoinColumn(name = "IdActor")
    private Actor actor;
    
    @ManyToOne
    @MapsId("IdSerie")
    @JoinColumn(name = "IdSerie")
    private Serie serie;

    public SerieActorKey getId() {
        return id;
    }

    public void setId(SerieActorKey id) {
        this.id = id;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie Serie) {
        this.serie = Serie;
    }
    
    
    
    
}
