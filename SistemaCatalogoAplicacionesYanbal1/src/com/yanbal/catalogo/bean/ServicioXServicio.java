/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "SERVICIO_X_SERVICIO", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicioXServicio.findAll", query = "SELECT s FROM ServicioXServicio s"),
    @NamedQuery(name = "ServicioXServicio.findByIdServicioDependiente", query = "SELECT s FROM ServicioXServicio s WHERE s.servicioXServicioPK.idServicioDependiente = :idServicioDependiente"),
    @NamedQuery(name = "ServicioXServicio.findByIdServicioBase", query = "SELECT s FROM ServicioXServicio s WHERE s.servicioXServicioPK.idServicioBase = :idServicioBase")})
public class ServicioXServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServicioXServicioPK servicioXServicioPK;
    
    @JoinColumn(name = "ID_SERVICIO_DEPENDIENTE", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servicio servicio;
    
    @JoinColumn(name = "ID_SERVICIO_BASE", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servicio servicio1;

    public ServicioXServicio() {
    }

    public ServicioXServicio(ServicioXServicioPK servicioXServicioPK) {
        this.servicioXServicioPK = servicioXServicioPK;
    }

    public ServicioXServicio(long idServicioDependiente, long idServicioBase) {
        this.servicioXServicioPK = new ServicioXServicioPK(idServicioDependiente, idServicioBase);
    }

    public ServicioXServicioPK getServicioXServicioPK() {
        return servicioXServicioPK;
    }

    public void setServicioXServicioPK(ServicioXServicioPK servicioXServicioPK) {
        this.servicioXServicioPK = servicioXServicioPK;
    }

    public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		servicioXServicioPK.setIdServicioDependiente(servicio.getId());
		this.servicio = servicio;
	}

	public Servicio getServicio1() {
		return servicio1;
	}

	public void setServicio1(Servicio servicio1) {
		servicioXServicioPK.setIdServicioBase(servicio1.getId());
		this.servicio1 = servicio1;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (servicioXServicioPK != null ? servicioXServicioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioXServicio)) {
            return false;
        }
        ServicioXServicio other = (ServicioXServicio) object;
        if ((this.servicioXServicioPK == null && other.servicioXServicioPK != null) || (this.servicioXServicioPK != null && !this.servicioXServicioPK.equals(other.servicioXServicioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.ServicioXServicio[ servicioXServicioPK=" + servicioXServicioPK + " ]";
    }
    
}
