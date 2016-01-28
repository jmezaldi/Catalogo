package com.yanbal.catalogo.datos.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yanbal.catalogo.bean.Usuario;
import com.yanbal.catalogo.excepciones.RecuperarDatosException;


@Stateless
public class UsuarioDao implements Serializable{
	
	static final Logger logger = LogManager.getLogger(UsuarioDao.class.getName());

	@PersistenceContext(unitName = "SistemaCatalogoAplicacionesYanbalPU")
	private EntityManager em;
	
	public Usuario buscar(String username, String password) throws RecuperarDatosException{
		try {
			Query query = em.createQuery("SELECT u FROM Usuario u");
			List<Usuario> usuarios = query.getResultList();
			
			logger.info("Listando usuarios : " + usuarios.size());
			for(int i = 0; i < usuarios.size(); i ++) {
				logger.info(usuarios.get(i));
			}
			query = em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username AND "
					+ "u.password = :password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			
			return (Usuario)query.getSingleResult();
		}
		catch(NoResultException e) {
			logger.info("No se encontro el usuario en la BD. User: " + username + " Password: " + password);
			return null;
		}
		catch(Exception e) {
			logger.error("Error al buscar un usuario en la BD. User: " + username + " Password: " + password, e);
			throw new RecuperarDatosException();
		}
	}


}
