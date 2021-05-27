/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Serie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jcorral
 */
@Local
public interface SerieFacadeLocal {

    void create(Serie serie);

    void edit(Serie serie);

    void remove(Serie serie);

    Serie find(Object id);

    List<Serie> findAll();

    List<Serie> findRange(int[] range);

    int count();
    
    List<Serie> consultaTodo(int index);
    
    Serie serieSeleccionada();
    
    void seleccionarSerie(int id);
}
