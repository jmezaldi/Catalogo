package com.yanbal.catalogo.negocio.servicios;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.yanbal.catalogo.bean.Usuario;
import com.yanbal.catalogo.datos.dao.UsuarioDao;
import com.yanbal.catalogo.excepciones.RecuperarDatosException;
import com.yanbal.catalogo.excepciones.ServicioException;

@Stateless
public class GestorUsuarios implements Serializable{
	@Inject
	private UsuarioDao usuarioDao;


	public Usuario buscar(String username, String password) throws ServicioException {
		try {
			Usuario usuario = usuarioDao.buscar(username, password);
			return usuario;
		} catch (RecuperarDatosException e) {
			throw new ServicioException("Error al buscar el usuario en la BD");
		}
	}
}
