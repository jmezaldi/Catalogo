/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.yanbal.catalogo.bean.Entidad;

/**
 *
 * @author usuario
 */
@Stateless
public class EntidadFacade extends AbstractFacade<Entidad> {
    @PersistenceContext(unitName = "SistemaCatalogoAplicacionesYanbalPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public EntidadFacade() {
        super(Entidad.class);
    }
    
    public List<Entidad> finAllByBD(){
    	
		CriteriaBuilder cb = em.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery q = cb.createQuery(Entidad.class);
		
		Root<Entidad> c = q.from(Entidad.class);
		q.select(c);
		q.where(cb.equal(c.get("idBaseDatos"), 22));
		return getEntityManager().createQuery(q).getResultList();
		
    }
}
