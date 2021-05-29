/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Genero;
import com.unileon.modelo.Pelicula;
import com.unileon.modelo.Serie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cl0ud7
 */
@Local
public interface GeneroFacadeLocal {

    void create(Genero genero);

    void edit(Genero genero);

    void remove(Genero genero);

    Genero find(Object id);

    List<Genero> findAll();

    List<Genero> findRange(int[] range);
    
    List<Genero> findGenerosPeli(Pelicula peli);
    
    List<Genero> findGenerosSerie(Serie serie);

    int count();

    
    
}
