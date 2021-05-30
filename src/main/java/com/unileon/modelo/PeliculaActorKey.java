/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Cl0ud7
 */
@Embeddable
public class PeliculaActorKey implements Serializable {
    
    @Column(name="IdPelicula")
    private int IdPelicula;
    
    @Column(name="IdActor")
    private int IdActor;

    public int getIdPelicula() {
        return IdPelicula;
    }

    public void setIdPelicula(int IdPelicula) {
        this.IdPelicula = IdPelicula;
    }

    public int getIdActor() {
        return IdActor;
    }

    public void setIdActor(int IdActor) {
        this.IdActor = IdActor;
    }
    
    
}
