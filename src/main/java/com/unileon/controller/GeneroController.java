/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.GeneroFacadeLocal;
import com.unileon.EJB.PeliculaFacadeLocal;
import com.unileon.EJB.SerieFacadeLocal;
import com.unileon.modelo.Genero;
import com.unileon.modelo.Pelicula;
import com.unileon.modelo.Serie;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Cl0ud7
 */
@Named
@ViewScoped
public class GeneroController implements Serializable{
    private Genero genero;
    private List<Genero> listaGeneros;
    private Pelicula pelicula;
    private Serie serie;

    @EJB
    private GeneroFacadeLocal generoEJB;
    
    @EJB
    private PeliculaFacadeLocal peliculaEJB;
    @EJB
    private SerieFacadeLocal serieEJB;
    
    @PostConstruct //Se accede después de crear la clase
    public void init(){
        genero = new Genero();

        try {
            pelicula = peliculaEJB.peliculaSeleccionada();
        } catch (Exception e) {
        }
        try {
            serie = serieEJB.serieSeleccionada();
        } catch (Exception e) {
        }
        try {
            listaGeneros = generoEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public void insertar(){
        try {
            generoEJB.create(genero);
            info();
        } catch (Exception e) {
        }
        
    }
    public List<Genero> listaGenerosPeli() {
        listaGeneros = generoEJB.findGenerosPeli(pelicula);
        return listaGeneros;
    }
    public List<Genero> listaGenerosSerie() {
        listaGeneros = generoEJB.findGenerosSerie(serie);
        return listaGeneros;
    }
    
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Género insertado correctamente"));
    }
    
    public Genero datos(){ 
        genero = generoEJB.generoSeleccionado();
        return genero;
    }
    
    public List<Pelicula> peliculas(int id){
        List<Pelicula> listaPeliculas = peliculaEJB.findAll();
        List<Pelicula> listaPeliculasGenero = new ArrayList<>();
        
        for (int i = 0; i < listaPeliculas.size(); i++) {
            listaGeneros = generoEJB.findGenerosPeli(listaPeliculas.get(i));
            for (int j = 0; j < listaGeneros.size(); j++) {
                if(listaGeneros.get(j).getId() == id){
                    listaPeliculasGenero.add(listaPeliculas.get(i));
                }
            }
            
        }
        return listaPeliculasGenero;
    }
    
    public List<Serie> series(int id){
        List<Serie> listaSeries = serieEJB.findAll();
        List<Serie> listaSeriesGenero = new ArrayList<>();
        
        for (int i = 0; i < listaSeries.size(); i++) {
            listaGeneros = generoEJB.findGenerosSerie(listaSeries.get(i));
            for (int j = 0; j < listaGeneros.size(); j++) {
                if(listaGeneros.get(j).getId() == id){
                    listaSeriesGenero.add(listaSeries.get(i));
                }
            }  
        }
        return listaSeriesGenero;
    }

    public String cambioPagina(Genero genero){
        generoEJB.seleccionarGenero(genero.getId());
        return "genero.softwareII";
    }
    
    public String rutaPortada(int id){
        String ruta = "../resources/imagenes/generos/"+id+".jpg";
        return ruta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.genero);
        hash = 53 * hash + Objects.hashCode(this.generoEJB);
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
        final GeneroController other = (GeneroController) obj;
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.generoEJB, other.generoEJB)) {
            return false;
        }
        return true;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public GeneroFacadeLocal getGeneroEJB() {
        return generoEJB;
    }

    public void setGeneroEJB(GeneroFacadeLocal generoEJB) {
        this.generoEJB = generoEJB;
    }

    public List<Genero> getListaGeneros() {
        return listaGeneros;
    }

    public void setListaGeneros(List<Genero> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }
    
    
    
    
}