/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.RolFacadeLocal;
import com.unileon.EJB.UsuarioFacadeLocal;
import com.unileon.modelo.Persona;
import com.unileon.modelo.Rol;
import com.unileon.modelo.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named
@ViewScoped
public class UsuarioController implements Serializable {
    private Usuario usuario;
    
    //Atributos Persona:
    private String apellido1;
    private String apellido2;
    private String nombre;
    private Date fechaNacimiento;
    private char sexo;
    
    //Atributos Usuario:
    private boolean estado;
    private Persona persona;
    private Rol rol;
    private String password;
    private Date ultimaConexion;
    private String user;
    
    private List<Rol> listaRoles;
    private List<String> listaDescripcionesRoles;

	@EJB
	private UsuarioFacadeLocal usuarioEJB;
        
        @EJB
        private RolFacadeLocal rolEJB;

	@PostConstruct //Se accede después de crear la clase
	public void init(){
                    try{
                        rol = new Rol();
                        usuario = new Usuario();
                        persona = new Persona();
                  
                    listaRoles = rolEJB.findAll();
                   }catch(Exception e){
                        System.out.println("error al buscar el rol" + e );
                   }
                    
	}

    //Da de alta al usuario en la BBDD:
    public String create(){
    
        //Inicializamos a la persona:
        try{
        persona.setNombre(nombre);
        persona.setApellido1(apellido1);
        persona.setApellido2(apellido2);
        persona.setFechaNacimeinto(fechaNacimiento);
        persona.setSexo(sexo);
                
        }catch(Exception e){
            System.out.println("Error al iniciar el objeto Persona " +e);
        }         
        //Inicializamos al usuario:
        try{
         this.usuario.setIdRol(rolEJB.find(rol.getIdRol()));
         this.usuario.setIdPersona(persona);

         usuario.setEstado(estado);
         usuario.setPassword(password);
         usuario.setUltimaConexion(ultimaConexion);
         usuario.setUser(user);

         usuarioEJB.create(usuario);
         System.out.println("El usuario se ha creado correctamente :)");
          }catch(Exception e){
              System.out.println("Error al iniciar el objeto Usuario " +e);

          }
      this.compruebaUsuario();
       return "index.html";
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String compruebaUsuario(){
        try{
            if(persona.getNombre().equals("")){
                FacesContext.getCurrentInstance().addMessage("idUserMal", new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención: ","Campo nombre vacío"));
                return "index.xhtml";
            }else if(persona.getApellido1().equals("")){
                FacesContext.getCurrentInstance().addMessage("idUserMal", new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención: ","Campo apellido1 vacío"));
                return "index.xhtml";
            }else if(persona.getApellido2().equals("")){
                FacesContext.getCurrentInstance().addMessage("idUserMal", new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención: ","Campo apellido2 vacío"));
                return "index.xhtml";
            }else{
                return "index.html";
            }
        }catch(Exception e){
          System.out.println("error al comporbar el usuario " + e );
        }
        return "index.html";
    }
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(Date ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public List<Rol> getRoles(){
       
        return this.listaRoles;
    }
    
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public List<String> getListaDescripcionesRoles() {
        return listaDescripcionesRoles;
    }

    public void setListaDescripcionesRoles(List<String> listaDescripcionesRoles) {
        this.listaDescripcionesRoles = listaDescripcionesRoles;
    }

    public RolFacadeLocal getRolEJB() {
        return rolEJB;
    }

    public void setRolEJB(RolFacadeLocal rolEJB) {
        this.rolEJB = rolEJB;
    }
	
	public void insertarUsuario(){
		usuarioEJB.create(usuario);
	}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.usuario);
        hash = 23 * hash + Objects.hashCode(this.usuarioEJB);
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
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.usuarioEJB, other.usuarioEJB)) {
            return false;
        }
        return true;
    }
        
}
