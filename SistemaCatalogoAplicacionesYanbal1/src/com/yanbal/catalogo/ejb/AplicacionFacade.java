package com.yanbal.catalogo.ejb;

import com.yanbal.catalogo.bean.Aplicacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Alicia Canta
 */
@Stateless
public class AplicacionFacade extends AbstractFacade<Aplicacion> {
    @PersistenceContext(unitName = "SistemaCatalogoAplicacionesYanbalPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AplicacionFacade() {
        super(Aplicacion.class);
    }
    
    
//    public List<Aplicacion> filter(int start, int size, String sortBy, boolean isAsc, Map<String, String> filters) {
//        JPAQuery query = new JPAQuery(em);
//        QAddress address = QAddress.address1;
//        query.from(address);
//        if (sortBy != null) {
//            if (isAsc) {
//                query.orderBy(address.addressId.asc());
//            } else {
//                query.orderBy(address.addressId.desc());
//            }
//        }
//        return query.offset(start).limit(size).list(address);
//    }
//
//    public List<Aplicacion> filterJpa(int start, int size, String sortBy, boolean isAsc, Map<String, String> filters) {
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<Aplicacion> criteria = builder.createQuery(Aplicacion.class);
//        Root<Aplicacion> entityRoot = criteria.from(Aplicacion.class);
//        criteria.select(entityRoot);
//        if (!filters.isEmpty()) {
//           // build predicate list
//        }
//        if (sortBy != null) {
//            Order order = isAsc ? builder.asc(entityRoot.get(sortBy)) : builder.desc(entityRoot.get(sortBy));
//            criteria.orderBy(order);
//        }
//        Query q = em.createQuery(criteria);
//        q.setFirstResult(start);
//        q.setMaxResults(size);
//        return q.getResultList();
//    }
}
