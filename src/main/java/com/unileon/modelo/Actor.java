/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author jcorral
 */
@Entity
@Table(name="Actor")
public class Actor implements Serializable{
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) //Hace que se autoincremente y le asocia el valor de tal forma que lo que cambiemos aquí se cambia en la BBDD
   private int id;
   
   @Column(name="Nombre")
   private String nombre;
   
   @Column(name="Apellido")
   private String apellido;
   
   @Column(name="Biografia")
   private String biografia;
   
   /*@ManyToMany(mappedBy = "actor")
   private List<Pelicula> peliculas; */
   
   @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
   @JoinTable(name = "pelicula_actor", joinColumns = { @JoinColumn(name = "IdActor") }, inverseJoinColumns = {
            @JoinColumn(name = "IdPelicula") })
    private Set<Pelicula> peliculas;
   
   @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
   @JoinTable(name = "serie_actor", joinColumns = { @JoinColumn(name = "IdActor") }, inverseJoinColumns = {
            @JoinColumn(name = "IdSerie") })
    private Set<Serie> series;
//   
//   @ManyToMany(mappedBy = "actor")
//    private List<Serie> series;
   
   //GETTERS Y SETTERS
    /*public void addPeli(Pelicula pelicula) {
        this.peliculas.add(pelicula);
        pelicula.
    }*/
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

//    public List<Pelicula> getPeliculas() {
//        return peliculas;
//    }
//
//    public void setPeliculas(List<Pelicula> peliculas) {
//        this.peliculas = peliculas;
//    }
//
//    public List<Serie> getSeries() {
//        return series;
//    }
//
//    public void setSeries(List<Serie> series) {
//        this.series = series;
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.apellido);
        hash = 79 * hash + Objects.hashCode(this.biografia);
//        hash = 79 * hash + Objects.hashCode(this.peliculas);
//        hash = 79 * hash + Objects.hashCode(this.series);
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
        final Actor other = (Actor) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.biografia, other.biografia)) {
            return false;
        }
//        if (!Objects.equals(this.peliculas, other.peliculas)) {
//            return false;
//        }
//        if (!Objects.equals(this.series, other.series)) {
//            return false;
//        }
        return true;
    }
   

   
}
