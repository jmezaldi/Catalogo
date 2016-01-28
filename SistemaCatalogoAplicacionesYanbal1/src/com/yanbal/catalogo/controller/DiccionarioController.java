package com.yanbal.catalogo.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.TreeNode;

import com.yanbal.catalogo.bean.Diccionario;

@ManagedBean(name = "diccionarioController")
@ViewScoped
public class DiccionarioController implements Serializable {

	private TreeNode root;

	@EJB
	private com.yanbal.catalogo.ejb.EntidadFacade ejbFacadeEntidad;
	@EJB
	private com.yanbal.catalogo.ejb.AtributoXEntidadFacade ejbFacadeAtributo;

	private Diccionario selectedDocument;

	@ManagedProperty("#{diccionarioService}")
	private DiccionarioService service;

	@PostConstruct
	public void init() {
		root = service.createDiccionario(ejbFacadeEntidad.findAll(),
				ejbFacadeAtributo.findAll());
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setService(DiccionarioService service) {
		this.service = service;
	}

	public Diccionario getSelectedDocument() {
		return selectedDocument;
	}

	public void setSelectedDocument(Diccionario selectedDocument) {
		this.selectedDocument = selectedDocument;
	}
}
