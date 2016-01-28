package com.yanbal.catalogo.datos.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yanbal.catalogo.bean.Aplicacion;
import com.yanbal.catalogo.bean.Usuario;
import com.yanbal.catalogo.excepciones.RecuperarDatosException;


@Stateless
public class EntityDao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 66583372244258249L;

	static final Logger logger = LogManager.getLogger(EntityDao.class.getName());

	@PersistenceContext(unitName = "SistemaCatalogoAplicacionesYanbalPU")
	private EntityManager em;
	
	public List<Aplicacion> listarAplicacion() throws RecuperarDatosException {
		try {			
			Query query = em.createQuery("SELECT u FROM Aplicacion u");
			List<Aplicacion> aplicacion = query.getResultList();
			return aplicacion;
		} catch (Exception e) {
			logger.fatal("No se pudo recuperar la lista de usuarios de la BD." + e.getMessage());
			throw new RecuperarDatosException();
		}
	}


}
