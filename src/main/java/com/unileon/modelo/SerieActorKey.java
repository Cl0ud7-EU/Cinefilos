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
public class SerieActorKey implements Serializable{
    
    @Column(name="IdSerie")
    private int IdSerie;

    @Column(name="IdActor")
    private int IdActor;

    public int getIdSerie() {
        return IdSerie;
    }

    public void setIdSerie(int IdSerie) {
        this.IdSerie = IdSerie;
    }

    public int getIdActor() {
        return IdActor;
    }

    public void setIdActor(int IdActor) {
        this.IdActor = IdActor;
    }
    
    
}
