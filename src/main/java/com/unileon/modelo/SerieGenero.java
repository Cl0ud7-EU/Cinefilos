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
@Entity(name = "SerieGenero")
@Table(name="serie_genero")
public class SerieGenero implements Serializable {
    
    @EmbeddedId
    private SerieGeneroKey id;
    
    @ManyToOne
    @MapsId("IdGenero")//Esto corresponde al nombre que le hemos dado en PeliculaActorKey
    @JoinColumn(name = "IdGenero")
    private Genero genero;
    
    @ManyToOne
    @MapsId("IdSerie")
    @JoinColumn(name = "IdSerie")
    private Serie serie;

    public SerieGeneroKey getId() {
        return id;
    }

    public void setId(SerieGeneroKey id) {
        this.id = id;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
    
    
}
