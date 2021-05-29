/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.UsuarioFacadeLocal;
import com.unileon.modelo.Usuario;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named
@ApplicationScoped
public class UsuarioController implements Serializable {
    private Usuario usuario;

    private String nombre;
    private String apellido;
    private String password;
    private String email;
    private int numeroTelefono;
    private Boolean rol;

    @EJB
    private UsuarioFacadeLocal usuarioEJB;

    @PostConstruct //Se accede después de crear la clase
    public void init(){
        usuario = new Usuario();
        //compruebaRol();
    }

    //Da de alta al usuario en la BBDD:
    public void insertarUsuario(){
        
        try{
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setPassword(password);
        usuario.setEmail(email);
        usuario.setNumeroTelefono(numeroTelefono);
                
        }catch(Exception e){
            System.out.println("Error al iniciar el objeto Usuario " +e);
        }         
        
        usuarioEJB.create(usuario);
        
        info();
    }
    public void compruebaRol() {
        //Usuario name = (Usuario) getObjectFromSession("LOGGEDIN_USER");
        try {
            usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

        } catch (Exception e) {
        }
        
        
        
    }
    public String compruebaUsuario(){
        
        usuario.setEmail(email);
        usuario.setPassword(password);

        if (usuarioEJB.verificarUsuario(usuario) != null) {
            usuario = usuarioEJB.verificarUsuario(usuario);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
            
            System.out.println("principal.xhtml");
            //compruebaRol();
            return "privado/principal.xhtml?faces-redirect=true";
            
        } else{
            System.out.println("permisosInsuficientes.xhtml");
            return "publico/permisosInsuficientes.xhtml?faces-redirect=true";
        }     
//        try{
//            if(persona.getNombre().equals("")){
//                FacesContext.getCurrentInstance().addMessage("idUserMal", new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención: ","Campo nombre vacío"));
//                return "index.xhtml";
//            }else if(persona.getApellido1().equals("")){
//                FacesContext.getCurrentInstance().addMessage("idUserMal", new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención: ","Campo apellido1 vacío"));
//                return "index.xhtml";
//            }else if(persona.getApellido2().equals("")){
//                FacesContext.getCurrentInstance().addMessage("idUserMal", new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención: ","Campo apellido2 vacío"));
//                return "index.xhtml";
//            }else{
//                return "index.html";
//            }
//        }catch(Exception e){
//          System.out.println("error al comporbar el usuario " + e );
//        }
//            return "index.html";
        
    }
    
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Usted se ha registrado correctamente"));
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public UsuarioFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    public Boolean getRol() {
        return rol;
    }

    public void setRol(Boolean rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.usuario);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.apellido);
        hash = 97 * hash + Objects.hashCode(this.password);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + this.numeroTelefono;
        hash = 97 * hash + Objects.hashCode(this.usuarioEJB);
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
        final UsuarioController other = (UsuarioController) obj;
        if (this.numeroTelefono != other.numeroTelefono) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.usuarioEJB, other.usuarioEJB)) {
            return false;
        }
        return true;
    }
    
    
        
}
