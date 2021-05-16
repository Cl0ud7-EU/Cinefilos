/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.ActorFacadeLocal;
import com.unileon.modelo.Actor;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author jcorral
 */
@Named
@ViewScoped
public class ActorController implements Serializable{
    
    private Actor actor;
    @EJB
    private ActorFacadeLocal actorEJB;
    
    @PostConstruct //Se accede después de crear la clase
    public void init(){
        actor = new Actor();
    }
    
    public void insertar(){
        try {
            actorEJB.create(actor);
        } catch (Exception e) {
        }
    } 
}
