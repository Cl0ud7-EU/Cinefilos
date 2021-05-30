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
@Entity(name = "PeliculaGenero")
@Table(name = "pelicula_genero")
public class PeliculaGenero implements Serializable {
    
    @EmbeddedId
    private PeliculaGeneroKey id;
    
    @ManyToOne
    @MapsId("IdPelicula")
    @JoinColumn(name = "IdPelicula")
    private Pelicula pelicula;
    
    @ManyToOne
    @MapsId("IdGenero")
    @JoinColumn(name = "IdGenero")
    private Genero genero;

    public PeliculaGeneroKey getId() {
        return id;
    }

    public void setId(PeliculaGeneroKey id) {
        this.id = id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    
    
}
