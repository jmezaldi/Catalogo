package com.yanbal.catalogo.negocio.servicios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.yanbal.catalogo.bean.Aplicacion;
import com.yanbal.catalogo.datos.dao.EntityDao;
import com.yanbal.catalogo.excepciones.RecuperarDatosException;
import com.yanbal.catalogo.excepciones.ServicioException;

@Stateless
public class GestorEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6699742337442283479L;
	@Inject
	private EntityDao entityDao;


	public List<Aplicacion> listarAplicaciones() throws ServicioException {
		List<Aplicacion> aplicaciones = new ArrayList<Aplicacion>();

		try {
			aplicaciones = entityDao.listarAplicacion();
			return aplicaciones;
		} catch (RecuperarDatosException e) {
			throw new ServicioException("No se pudo recuperar la informacion de los usuarios");
		}
	}
}
