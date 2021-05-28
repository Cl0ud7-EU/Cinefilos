/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Director;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jcorral
 */
@Local
public interface DirectorFacadeLocal {

    void create(Director director);

    void edit(Director director);

    void remove(Director director);

    Director find(Object id);

    List<Director> findAll();

    List<Director> findRange(int[] range);

    int count();
    
    Director directorSeleccionado();
    
    void seleccionarDirector(int id);
    
}
