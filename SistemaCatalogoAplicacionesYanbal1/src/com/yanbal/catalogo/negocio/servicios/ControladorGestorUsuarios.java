package com.yanbal.catalogo.negocio.servicios;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.yanbal.catalogo.bean.Usuario;

@ManagedBean(name = "backGestorUsuarios")
public class ControladorGestorUsuarios {
	private Usuario usuario;
	private boolean esNuevoUsuario;

	@PostConstruct
	public void inicializar() {
		Object parametro = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

		if (parametro != null) {
			usuario = (Usuario) parametro;
			esNuevoUsuario = false;
		} else {
			usuario = new Usuario();
			esNuevoUsuario = true;
		}
	}

	public void guardar() {
		RequestContext.getCurrentInstance().closeDialog(usuario);
	}

	public void cancelar() {
		RequestContext.getCurrentInstance().closeDialog(null);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isEsNuevoUsuario() {
		return esNuevoUsuario;
	}

	public void setEsNuevoUsuario(boolean esNuevoUsuario) {
		this.esNuevoUsuario = esNuevoUsuario;
	}
}
