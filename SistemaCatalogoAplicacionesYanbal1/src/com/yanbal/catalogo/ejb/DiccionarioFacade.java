package com.yanbal.catalogo.ejb;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.yanbal.catalogo.bean.Diccionario;
import com.yanbal.catalogo.bean.Entidad;

/**
 *
 * @author usuario
 */
@Stateless
public class DiccionarioFacade extends AbstractFacade<Diccionario> {
    @PersistenceContext(unitName = "SistemaCatalogoAplicacionesYanbalPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public DiccionarioFacade() {
        super(Diccionario.class);
    }
    

}

