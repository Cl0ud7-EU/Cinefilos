/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.modelo;

import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jcorral
 */
@Entity
@Table(name="Serie")
public class Serie implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column (name="Titulo")
    private String titulo;
    
    @Column (name="AnyoInicio")
    private int anyoInicio;
    
    @Column (name="Temporadas")
    private int temporadas;
    
    @Column (name="Sinopsis")
    private String sinopsis;
    
    @Column (name="Puntuacion")
    private float puntuacion;
    
    @JoinColumn (name="idCompania")
    @ManyToOne
    private Compania compania;
    
//    @JoinTable(
//        name = "serie_genero",
//        joinColumns = @JoinColumn(name = "IdSerie", nullable = false),
//        inverseJoinColumns = @JoinColumn(name="IdGenero", nullable = false)
//    )
//    
//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Genero> generos;
//   
//    public void addGenero(Genero genero){
//        if(this.generos == null){
//            this.generos = new ArrayList<>();
//        }
//        
//        this.generos.add(genero);
//    }
//    
//    @JoinTable(
//        name = "serie_actor",
//        joinColumns = @JoinColumn(name = "IdSerie", nullable = false),
//        inverseJoinColumns = @JoinColumn(name="IdActor", nullable = false)
//    )
//    
//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Actor> actores;
//   
//    public void addActor(Actor actor){
//        if(this.actores == null){
//            this.actores = new ArrayList<>();
//        }
//        
//        this.actores.add(actor);
//    }


//    public List<Genero> getGeneros() {
//        return generos;
//    }
//
//    public void setGeneros(List<Genero> generos) {
//        this.generos = generos;
//    }
//
//    public List<Actor> getActores() {
//        return actores;
//    }
//
//    public void setActores(List<Actor> actores) {
//        this.actores = actores;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnyoInicio() {
        return anyoInicio;
    }

    public void setAnyoInicio(int anyoInicio) {
        this.anyoInicio = anyoInicio;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.titulo);
        hash = 83 * hash + this.anyoInicio;
        hash = 83 * hash + this.temporadas;
        hash = 83 * hash + Objects.hashCode(this.sinopsis);
        hash = 83 * hash + Float.floatToIntBits(this.puntuacion);
        hash = 83 * hash + Objects.hashCode(this.compania);
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
        final Serie other = (Serie) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.anyoInicio != other.anyoInicio) {
            return false;
        }
        if (this.temporadas != other.temporadas) {
            return false;
        }
        if (Float.floatToIntBits(this.puntuacion) != Float.floatToIntBits(other.puntuacion)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.sinopsis, other.sinopsis)) {
            return false;
        }
        if (!Objects.equals(this.compania, other.compania)) {
            return false;
        }
        return true;
    }



    
   
}
