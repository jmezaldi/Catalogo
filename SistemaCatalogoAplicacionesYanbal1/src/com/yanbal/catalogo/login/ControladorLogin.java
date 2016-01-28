package com.yanbal.catalogo.login;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.context.RequestContext;

import java.util.ArrayList;
import java.util.Hashtable ;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;


import com.yanbal.catalogo.bean.Diccionario;
import com.yanbal.catalogo.bean.Usuario;
import com.yanbal.catalogo.controller.util.JsfUtil;
import com.yanbal.catalogo.ejb.DiccionarioFacade;
import com.yanbal.catalogo.excepciones.ServicioException;
import com.yanbal.catalogo.negocio.servicios.GestorUsuarios;
import com.yanbal.catalogo.util.MensajesJSF;


@ManagedBean(name = "backLogin")
@SessionScoped
public class ControladorLogin implements Serializable{
	static final Logger logger = LogManager.getLogger(ControladorLogin.class.getName());

	@EJB
	private DiccionarioFacade ejbDiccionario;
	
	private Usuario usuario;
	@EJB
	//private GestorUsuarios gestorUsuarios;
	private GestorUsuarios gestorUsuarios;
	private String username;
	private String password;

	private Hashtable<String, Diccionario> hashtableDescripciones = new Hashtable<String, Diccionario>();

	
	
	public void login() {
		try {
			usuario = gestorUsuarios.buscar(username, password);
			this.cargarDescripciones();
			if (usuario != null) {
				logger.info("Login correcto. " + usuario);
				MensajesJSF.mostrarMensaje("Login", "Bienvenido " + username);
				RequestContext.getCurrentInstance().addCallbackParam("loggedIn", true);
				redigirPagina("/faces/menu.xhtml");
			} else {
				logger.info("Login incorrecto. Username: " + username + " Password: " + password);
				MensajesJSF.mostrarMensaje("Login", "Credenciales incorrectas");
				RequestContext.getCurrentInstance().addCallbackParam("loggedIn", false);
			}

		} catch (ServicioException e) {
			MensajesJSF.mostrarError("Login", e.getMessage());
		}
	}

	public void logout() {
		usuario = null;
		redigirPagina("/faces/login.xhtml");
	}

	private void redigirPagina(String nombrePagina) {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect(ec.getRequestContextPath() + nombrePagina);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void verificarAccesoMonitor(ComponentSystemEvent event) {
		if (usuario == null) {
			redigirPagina("/faces/login.xhtml");
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void cargarDescripciones(){
		try{
				List<Diccionario> arrayList = (List<Diccionario>)ejbDiccionario.findAll();
				Iterator<Diccionario> it = arrayList.iterator();
				while (it.hasNext()){
					Diccionario dic = it.next();
					hashtableDescripciones.put(dic.getNombre(),dic);
				}
		}catch(Exception e){
			MensajesJSF.mostrarError("Error cargando Diccionario", e.getMessage());
		
		}
	}
	
	public String obtenerSignificado(String etiqueta){
		Diccionario d = hashtableDescripciones.get(etiqueta);
		if (d == null) return ""; 
		return d.getDescripcion();
	}
	
	public String obtenerDescripcionLarga(String etiqueta){
		Diccionario d = hashtableDescripciones.get(etiqueta);
		if (d == null) return ""; 
		return d.getDescripcionLarga();
		
	}
}
